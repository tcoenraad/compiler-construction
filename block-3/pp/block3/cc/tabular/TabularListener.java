// Generated from /Users/twancoenraad/Code/compiler-construction/block-3/pp/block3/cc/tabular/Tabular.g4 by ANTLR 4.5
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TabularParser}.
 */
public interface TabularListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull TabularParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull TabularParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(@NotNull TabularParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(@NotNull TabularParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#cell}.
	 * @param ctx the parse tree
	 */
	void enterCell(@NotNull TabularParser.CellContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#cell}.
	 * @param ctx the parse tree
	 */
	void exitCell(@NotNull TabularParser.CellContext ctx);
}