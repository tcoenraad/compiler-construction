package pp.block2.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.antlr.SentenceParser.ModifierContext;
import pp.block2.cc.antlr.SentenceParser.ObjectContext;
import pp.block2.cc.antlr.SentenceParser.SentenceContext;
import pp.block2.cc.antlr.SentenceParser.SubjectContext;

public class SentenceCounter extends SentenceBaseListener {
	public void process(String text) {
		depths = new ParseTreeProperty<Integer>();
		termCount = 0;
		errorCount = 0;
		Lexer lexer = new SentenceLexer(new ANTLRInputStream(text));
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		System.out.printf("Results for '%s':%n", text);
		System.out.printf("Parse tree: %s%n", tree.toStringTree(parser));
		System.out.printf("Tree depth: %d%n", getDepth(tree));
		System.out.printf("Terminals:  %d%n", termCount);
		System.out.printf("Errors:     %d%n%n", errorCount);
	}

	@Override
	public void exitSentence(SentenceContext ctx) {
		computeDepth(ctx);
	}

	@Override
	public void exitSubject(SubjectContext ctx) {
		computeDepth(ctx);
	}

	@Override
	public void exitModifier(ModifierContext ctx) {
		computeDepth(ctx);
	}

	@Override
	public void exitObject(ObjectContext ctx) {
		computeDepth(ctx);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		setDepth(node, 1);
		termCount++;
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		setDepth(node, 1);
		errorCount++;
	}

	/**
	 * Adds the sub-ASTs corresponding to the children of a given 
	 * Antlr tree to an AST, and sets the AST property of the tree.
	 */
	private void computeDepth(ParseTree tree) {
		int depth = 1;
		for (int i = 0; i < tree.getChildCount(); i++) {
			depth = Math.max(depth, getDepth(tree.getChild(i)) + 1);
		}
		setDepth(tree, depth);
	}

	/** Returns the stored depth of a given Antlr parse tree. */
	private Integer getDepth(ParseTree node) {
		return depths.get(node);
	}

	/** Stores the depth of a given Antlr parse tree. */
	private void setDepth(ParseTree node, Integer ast) {
		depths.put(node, ast);
	}

	/** Map from Antlr tree nodes to ASTs. */
	private ParseTreeProperty<Integer> depths;
	/** Number of terminal nodes. */
	private int termCount;
	/** Number of error nodes. */
	private int errorCount;

	public static void main(String[] args) {
		SentenceCounter counter = new SentenceCounter();
		counter.process("students love students.");
		counter.process("all undergraduate students love all compilers.");
		counter.process("all smart students love all compilers");
		counter.process("undergraduate students love love.");
		counter.process("all undergraduate students all compilers.");
	}
}
