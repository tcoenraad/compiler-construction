package pp.block5.cc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import pp.block5.cc.pascal.SimplePascalLexer;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.block5.cc.simple.Checker;
import pp.block5.cc.simple.Generator;
import pp.block5.cc.simple.Result;
import pp.iloc.Simulator;
import pp.iloc.model.Program;

public class SimplePascalCompiler {
	/** The singleton instance of this class. */
	private final static SimplePascalCompiler instance = new SimplePascalCompiler();
	/** Debug flag. */
	private final static boolean SHOW = true;

	/** Returns the singleton instance of this class. */
	public static SimplePascalCompiler instance() {
		return instance;
	}

	/** Compiles and runs the program named in the argument. */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: filename");
			return;
		}
		try {
			System.out.println("--- Running " + args[0]);
			Program prog = instance().compile(new File(args[0]));
			if (SHOW) {
				System.out.println(prog.prettyPrint());
			}
			Simulator sim = new Simulator(prog);
			sim.run();
			System.out.println("--- Done with " + args[0]);
		} catch (ParseException exc) {
			exc.print();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/** The fixed checker of this compiler. */
	private final Checker checker;
	/** The fixed generator of this compiler. */
	private final Generator generator;

	private SimplePascalCompiler() {
		this.checker = new Checker();
		this.generator = new Generator();
	}

	/** Typechecks a given Simple Pascal string. */
	public Result check(String text) throws ParseException {
		return check(parse(text));
	}

	/** Typechecks a given Simple Pascal file. */
	public Result check(File file) throws ParseException, IOException {
		return check(parse(file));
	}

	/** Typechecks a given Simple Pascal parse tree. */
	public Result check(ParseTree tree) throws ParseException {
		return this.checker.check(tree);
	}

	/** Compiles a given Simple Pascal string into an ILOC program. */
	public Program compile(String text) throws ParseException {
		return compile(parse(text));
	}

	/** Compiles a given Simple Pascal file into an ILOC program. */
	public Program compile(File file) throws ParseException, IOException {
		return compile(parse(file));
	}

	/** Compiles a given Simple Pascal parse tree into an ILOC program. */
	public Program compile(ParseTree tree) throws ParseException {
		Result checkResult = this.checker.check(tree);
		return this.generator.generate(tree, checkResult);
	}

	/** Compiles a given Simple Pascal string into a parse tree. */
	public ParseTree parse(String text) throws ParseException {
		return parse(new ANTLRInputStream(text));
	}

	/** Compiles a given Simple Pascal string into a parse tree. */
	public ParseTree parse(File file) throws ParseException, IOException {
		return parse(new ANTLRInputStream(new FileReader(file)));
	}

	private ParseTree parse(CharStream chars) throws ParseException {
		ErrorListener listener = new ErrorListener();
		Lexer lexer = new SimplePascalLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		SimplePascalParser parser = new SimplePascalParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree result = parser.program();
		listener.throwException();
		return result;
	}
}
