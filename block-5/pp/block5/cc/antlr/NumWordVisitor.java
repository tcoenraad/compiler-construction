// Generated from C:/Users/Jip/Documents/compiler-construction/block-5/pp/block5/cc/antlr\NumWord.g4 by ANTLR 4.5
package pp.block5.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NumWordParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NumWordVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NumWordParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(@NotNull NumWordParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull NumWordParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link NumWordParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(@NotNull NumWordParser.WordContext ctx);
}