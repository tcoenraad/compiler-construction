// Generated from /Users/twancoenraad/Code/compiler-construction/block-2/pp/block2/cc/antlr/Expression.g4 by ANTLR 4.5
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull ExpressionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull ExpressionParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(@NotNull ExpressionParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(@NotNull ExpressionParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code times}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTimes(@NotNull ExpressionParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code times}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTimes(@NotNull ExpressionParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull ExpressionParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull ExpressionParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPower(@NotNull ExpressionParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPower(@NotNull ExpressionParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(@NotNull ExpressionParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(@NotNull ExpressionParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(@NotNull ExpressionParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(@NotNull ExpressionParser.PlusContext ctx);
}