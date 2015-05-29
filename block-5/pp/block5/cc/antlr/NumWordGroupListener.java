// Generated from /Users/twancoenraad/Code/compiler-construction/block-5/pp/block5/cc/antlr/NumWordGroup.g4 by ANTLR 4.5
package pp.block5.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumWordGroupParser}.
 */
public interface NumWordGroupListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NumWordGroupParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(@NotNull NumWordGroupParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordGroupParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(@NotNull NumWordGroupParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordGroupParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(@NotNull NumWordGroupParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordGroupParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(@NotNull NumWordGroupParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordGroupParser#penultimateGroup}.
	 * @param ctx the parse tree
	 */
	void enterPenultimateGroup(@NotNull NumWordGroupParser.PenultimateGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordGroupParser#penultimateGroup}.
	 * @param ctx the parse tree
	 */
	void exitPenultimateGroup(@NotNull NumWordGroupParser.PenultimateGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordGroupParser#lastGroup}.
	 * @param ctx the parse tree
	 */
	void enterLastGroup(@NotNull NumWordGroupParser.LastGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordGroupParser#lastGroup}.
	 * @param ctx the parse tree
	 */
	void exitLastGroup(@NotNull NumWordGroupParser.LastGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordGroupParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull NumWordGroupParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordGroupParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull NumWordGroupParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumWordGroupParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(@NotNull NumWordGroupParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumWordGroupParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(@NotNull NumWordGroupParser.WordContext ctx);
}