// Generated from /Users/twancoenraad/Code/compiler-construction/block-3/pp/block3/cc/antlr/CC5/CC3Attr.g4 by ANTLR 4.5
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CC3AttrParser}.
 */
public interface CC3AttrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CC3AttrParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull CC3AttrParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CC3AttrParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull CC3AttrParser.TermContext ctx);
}