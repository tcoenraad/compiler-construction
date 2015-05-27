package pp.iloc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.iloc.model.Instr;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.OpList;
import pp.iloc.model.Operand;
import pp.iloc.model.Operand.Type;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
import pp.iloc.model.Str;
import pp.iloc.parse.ErrorListener;
import pp.iloc.parse.FormatException;
import pp.iloc.parse.ILOCBaseListener;
import pp.iloc.parse.ILOCLexer;
import pp.iloc.parse.ILOCParser;
import pp.iloc.parse.ILOCParser.CommentContext;
import pp.iloc.parse.ILOCParser.DeclContext;
import pp.iloc.parse.ILOCParser.InstrContext;
import pp.iloc.parse.ILOCParser.InstrListContext;
import pp.iloc.parse.ILOCParser.OpCodeContext;
import pp.iloc.parse.ILOCParser.OperandContext;
import pp.iloc.parse.ILOCParser.ProgramContext;
import pp.iloc.parse.ILOCParser.RealOpContext;
import pp.iloc.parse.ILOCParser.SingleInstrContext;
import pp.iloc.parse.ILOCParser.SourcesContext;
import pp.iloc.parse.ILOCParser.TargetsContext;

/** Assembler for the ILOC language. */
public class Assembler {
	private final ILOCWalker walker;

	/** Constructor for the singleton instance. */
	private Assembler() {
		this.walker = new ILOCWalker();
	}

	/** Parses a given ILOC program given as a string, 
	 * and returns the parsed program. 
	 * @throws FormatException if there was an error parsing the program
	 */
	public Program assemble(String program) throws FormatException {
		return assemble(new ANTLRInputStream(program));
	}

	/** Parses a given ILOC program given as a file, 
	 * and returns the parsed program. 
	 * @throws FormatException if there was an error parsing the program
	 */
	public Program assemble(File file) throws FormatException, IOException {
		return assemble(new ANTLRInputStream(new FileReader(file)));
	}

	/** Parses a given ILOC program given as a character stream, 
	 * and returns the parsed program. 
	 * @throws FormatException if there was an error parsing the program
	 */
	public Program assemble(CharStream chars) throws FormatException {
		ErrorListener listener = new ErrorListener();
		Lexer lexer = new ILOCLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		ILOCParser parser = new ILOCParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.program();
		if (listener.hasErrors()) {
			throw new FormatException(listener.getErrors());
		}
		return assemble(tree);
	}

	/** Parses a given ILOC program given as a parse tree, 
	 * and returns the parsed program. 
	 * @throws FormatException if there was an error parsing the program
	 */
	public Program assemble(ParseTree tree) throws FormatException {
		Program result = this.walker.walk(tree);
		result.check();
		return result;
	}

	/** Returns the singleton assembler instance. */
	public static final Assembler instance() {
		return INSTANCE;
	}

	private static final Assembler INSTANCE = new Assembler();

	private static class ILOCWalker extends ILOCBaseListener {
		/** The program to be built. */
		private Program program;
		/** Instructions associated with @{code instr} parse nodes. */
		private ParseTreeProperty<Instr> instrs;
		/** Operations associated with @{code op} parse nodes. */
		private ParseTreeProperty<Op> ops;
		/** Operands associated with @{code operand} parse nodes. */
		private ParseTreeProperty<Operand> operands;
		/** Operand lists associated with @{code sources} parse nodes. */
		private ParseTreeProperty<List<Operand>> sources;
		/** Operand lists associated with targets parse nodes. */
		private ParseTreeProperty<List<Operand>> targets;
		/** Mapping of labels to place of declaration. */
		private Map<Label, Token> labelMap;
		/** Mapping of symbolic constants to place of initialisation. */
		private Map<Num, Token> symbolMap;
		/** The error listener of this walker. */
		private ErrorListener errors;

		public Program walk(ParseTree tree) throws FormatException {
			// initialise the data structures
			this.program = new Program();
			this.instrs = new ParseTreeProperty<>();
			this.ops = new ParseTreeProperty<>();
			this.operands = new ParseTreeProperty<>();
			this.sources = new ParseTreeProperty<>();
			this.targets = new ParseTreeProperty<>();
			this.labelMap = new HashMap<>();
			this.symbolMap = new HashMap<>();
			this.errors = new ErrorListener();
			new ParseTreeWalker().walk(this, tree);
			if (this.errors.hasErrors()) {
				throw new FormatException(this.errors.getErrors());
			}
			return this.program;
		}

		@Override
		public void exitDecl(DeclContext ctx) {
			Num symbol = new Num(ctx.ID().getText());
			if (addSymbol(ctx.getStart(), symbol)) {
				this.program.setSymb(symbol,
						Integer.parseInt(ctx.NUM().getText()));
			}
		}

		@Override
		public void exitInstrList(InstrListContext ctx) {
			OpList result = new OpList();
			if (ctx.label() != null) {
				Label label = new Label(ctx.label().getText());
				if (addLabel(ctx.getStart(), label)) {
					result.setLabel(label);
				}
			}
			for (ParseTree op : ctx.op()) {
				Op instr = getOp(op);
				// op may be null if there was a format error
				if (instr != null) {
					result.addOp(instr);
				}
			}
			addInstr(ctx, result);
		}

		@Override
		public void exitSingleInstr(SingleInstrContext ctx) {
			Instr result = getOp(ctx.op());
			// op may be null if there was a format error
			if (result != null) {
				if (ctx.label() != null) {
					Label label = new Label(ctx.label().getText());
					if (addLabel(ctx.getStart(), label)) {
						result.setLabel(label);
					}
				}
				addInstr(ctx, result);
			}
		}

		@Override
		public void exitComment(CommentContext ctx) {
			Op result = new Op(OpCode.comment);
			String comment = ctx.COMMENT().getText();
			comment = comment.substring(2).trim();
			result.setComment(comment);
			addOp(ctx, result);
		}

		@Override
		public void exitRealOp(RealOpContext ctx) {
			OpCodeContext opCodeTree = ctx.opCode();
			OpCode code = OpCode.parse(opCodeTree.getText());
			if (code == null) {
				this.errors.visitError(
						opCodeTree.getStart(),
						"Unrecognized opcode '%s'", opCodeTree.getText());
				return;
			}
			// collect operands
			List<Operand> opnds = new ArrayList<>();
			try {
				List<Operand> sources = getSources(ctx.sources());
				opnds.addAll(getOpnds(code, "source", code.getSourceSig(),
						sources));
				List<Operand> targets = getTargets(ctx.targets());
				opnds.addAll(getOpnds(code, "target", code.getTargetSig(),
						targets));
			} catch (FormatException e) {
				this.errors.visitError(opCodeTree.getStart(), e.getMessage());
				return;
			}
			// check for correct arrow symbol
			if (!code.getTargetSig().isEmpty()) {
				String expected = code.getClaz().getArrow();
				TerminalNode arrowToken = ctx.DARROW() == null ? ctx.ARROW() : ctx.DARROW();
				String actual = arrowToken.getText();
				if (!expected.equals(actual)) {
					this.errors.visitError(arrowToken.getSymbol(),
							"Expected '%s' but found '%s'", expected, actual);
				}
			}
			Op result = new Op(code, opnds);
			if (ctx.COMMENT() != null) {
				String comment = ctx.COMMENT().getText();
				comment = comment.substring(2).trim();
				result.setComment(comment);
			}
			addOp(ctx, result);
		}

		private List<Operand> getOpnds(OpCode code, String role,
				List<Type> sig, List<Operand> orig) throws FormatException {
			List<Operand> result = new ArrayList<>();
			if (orig == null) {
				orig = Collections.emptyList();
			}
			if (orig.size() != sig.size()) {
				throw new FormatException(
						"Opcode '%s' expects %d %s parameters, but has %d",
						code.name(), sig.size(), role, orig.size());
			}
			for (int i = 0; i < orig.size(); i++) {
				Operand opnd = orig.get(i);
				Type actualType = opnd.getType();
				Type expectedType = sig.get(i);
				if (expectedType == Type.REG && actualType == Type.LABEL) {
					opnd = new Reg(((Label) opnd).getValue());
				} else if (expectedType != actualType) {
					throw new FormatException(
							"Opcode '%s' %s operand %d should be %s but is %s",
							code.name(), role, i, expectedType.name(),
							actualType.name());
				}
				result.add(opnd);
			}
			return result;
		}

		@Override
		public void exitProgram(ProgramContext ctx) {
			for (InstrContext instr : ctx.instr()) {
				Instr i = getInstr(instr);
				if (i != null) {
					this.program.addInstr(i);
				}
			}
		}

		@Override
		public void exitSources(SourcesContext ctx) {
			List<Operand> result = new ArrayList<>();
			for (ParseTree o : ctx.operand()) {
				result.add(getOperand(o));
			}
			addSources(ctx, result);
		}

		@Override
		public void exitTargets(TargetsContext ctx) {
			List<Operand> result = new ArrayList<>();
			for (ParseTree o : ctx.operand()) {
				result.add(getOperand(o));
			}
			addTargets(ctx, result);
		}

		@Override
		public void exitOperand(OperandContext ctx) {
			Operand result;
			if (ctx.STR() != null) {
				String str = ctx.STR().getText();
				result = new Str(str.substring(1, str.length() - 1).replaceAll(
						"\\\"", "\""));
			} else if (ctx.NUM() != null) {
				result = new Num(Integer.parseInt(ctx.NUM().getText()));
			} else if (ctx.SYMB() != null) {
				result = new Num(ctx.SYMB().getText().substring(1));
			} else if (ctx.LAB() != null) {
				result = new Num(
						new Label(ctx.LAB().getText().substring(1)));
			} else {
				result = new Label(ctx.ID().getText());
			}
			addOperand(ctx, result);
		}

		/** Sets the instruction attribute of a given node. */
		private void addInstr(ParseTree node, Instr instr) {
			this.instrs.put(node, instr);
		}

		/** Returns the instruction attribute of a given node. */
		private Instr getInstr(ParseTree node) {
			return this.instrs.get(node);
		}

		/** Sets the operation attribute of a given node. */
		private void addOp(ParseTree node, Op op) {
			this.ops.put(node, op);
		}

		/** Returns the operation attribute of a given node. */
		private Op getOp(ParseTree node) {
			return this.ops.get(node);
		}

		/** Sets the operand attribute of a given node. */
		private void addOperand(ParseTree node, Operand operand) {
			this.operands.put(node, operand);
		}

		/** Returns the operand attribute of a given node. */
		private Operand getOperand(ParseTree node) {
			return this.operands.get(node);
		}

		/** Sets the source operand list attribute of a given node. */
		private void addSources(ParseTree node, List<Operand> sources) {
			this.sources.put(node, sources);
		}

		/** Returns the source operand list attribute of a given node. */
		private List<Operand> getSources(ParseTree node) {
			return this.sources.get(node);
		}

		/** Sets the target operand list attribute of a given node. */
		private void addTargets(ParseTree node, List<Operand> targets) {
			this.targets.put(node, targets);
		}

		/** Returns the target operand list attribute of a given node. */
		private List<Operand> getTargets(ParseTree node) {
			return this.targets.get(node);
		}

		/** Registers label definition. Signals an error if the label
		 * was already defined.
		 * @return {@code true} if the label was new
		 */
		private boolean addLabel(Token token, Label label) {
			Token oldToken = this.labelMap.put(label, token);
			if (oldToken != null) {
				this.errors.visitError(token,
						"Label '%s' already defined at line %d", label,
						oldToken.getLine());
			}
			return oldToken == null;
		}

		/** Registers a symbol initialisation. Signals an error if the 
		 * symbol was already initialised.
		 * @return {@code true} if the symbol was new
		 */
		private boolean addSymbol(Token token, Num symbol) {
			Token oldToken = this.symbolMap.put(symbol, token);
			if (oldToken != null) {
				this.errors.visitError(token,
						"Symbolic constant '%s' already defined at line %d",
						symbol, oldToken.getLine());
			}
			return oldToken == null;
		}
	}
}
