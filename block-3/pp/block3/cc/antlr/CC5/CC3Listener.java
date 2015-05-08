// Generated from /Users/twancoenraad/Code/compiler-construction/block-3/pp/block3/cc/antlr/CC5/CC3.g4 by ANTLR 4.5
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CC3Parser}.
 */
public interface CC3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterPar(@NotNull CC3Parser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitPar(@NotNull CC3Parser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterEqual(@NotNull CC3Parser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitEqual(@NotNull CC3Parser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull CC3Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull CC3Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull CC3Parser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull CC3Parser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull CC3Parser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull CC3Parser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterHat(@NotNull CC3Parser.HatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitHat(@NotNull CC3Parser.HatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterPlus(@NotNull CC3Parser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link CC3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitPlus(@NotNull CC3Parser.PlusContext ctx);
}