package pp.block4.cc.iloc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.iloc.Simulator;
import pp.iloc.model.*;

/** Compiler from Calc.g4 to ILOC. */
public class CalcCompiler extends CalcBaseListener {
	/** Program under construction. */
	private Program prog;

    // Attribute maps and other fields
	private ParseTreeProperty<Reg> registers;
    private int numberOfRegisters;

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.complete();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
        prog = new Program();
		registers = new ParseTreeProperty<>();
        numberOfRegisters = 0;

        addNewRegister(tree);
        new ParseTreeWalker().walk(this, tree);
        emit(OpCode.out, new Str(""), new Reg("r_" + (numberOfRegisters - 1)));
        return prog;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private void emit(OpCode opCode, Operand... args) {
        prog.addInstr(new Op(opCode, args));
    }

    /** Adds a new register to the list of registers. */
    private void addNewRegister(ParseTree tree){
        registers.put(tree, new Reg("r_" + numberOfRegisters));
        numberOfRegisters++;
    }

	@Override
    public void exitPar(@NotNull CalcParser.ParContext ctx) {
        addNewRegister(ctx);
        emit(OpCode.i2i, registers.get(ctx.expr()), registers.get(ctx));
    }

    @Override
    public void exitMinus(@NotNull CalcParser.MinusContext ctx) {
        addNewRegister(ctx);

        Reg expr = registers.get(ctx.expr());
        emit(OpCode.rsubI, new Num(0), expr, registers.get(ctx));
    }

    @Override
    public void exitNumber(@NotNull CalcParser.NumberContext ctx) {
        addNewRegister(ctx);
        emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), registers.get(ctx));
    }

    @Override
    public void exitTimes(@NotNull CalcParser.TimesContext ctx) {
        addNewRegister(ctx);

        Reg expr0 = registers.get(ctx.expr(0));
        Reg expr1 = registers.get(ctx.expr(1));
        emit(OpCode.mult, expr0, expr1, registers.get(ctx));
    }

    @Override
    public void exitPlus(@NotNull CalcParser.PlusContext ctx) {
        addNewRegister(ctx);

        Reg expr0 = registers.get(ctx.expr(0));
        Reg expr1 = registers.get(ctx.expr(1));
        emit(OpCode.add, expr0, expr1, registers.get(ctx));
    }

	/** Calls the compiler, and simulates and prints the compiled program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [expr]+");
			return;
		}
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : args) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}
}
