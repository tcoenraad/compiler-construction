// Generated from C:/Users/Jip/Documents/compiler-construction/block-5/pp/block5/cc/pascal\SimplePascal.g4 by ANTLR 4.5
package pp.block5.cc.pascal;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimplePascalParser}.
 */
public interface SimplePascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull SimplePascalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull SimplePascalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull SimplePascalParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull SimplePascalParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link SimplePascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull SimplePascalParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link SimplePascalParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull SimplePascalParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull SimplePascalParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull SimplePascalParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull SimplePascalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull SimplePascalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssStat(@NotNull SimplePascalParser.AssStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssStat(@NotNull SimplePascalParser.AssStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull SimplePascalParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull SimplePascalParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull SimplePascalParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull SimplePascalParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(@NotNull SimplePascalParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(@NotNull SimplePascalParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterInStat(@NotNull SimplePascalParser.InStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitInStat(@NotNull SimplePascalParser.InStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterOutStat(@NotNull SimplePascalParser.OutStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code outStat}
	 * labeled alternative in {@link SimplePascalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitOutStat(@NotNull SimplePascalParser.OutStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link SimplePascalParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(@NotNull SimplePascalParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link SimplePascalParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(@NotNull SimplePascalParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull SimplePascalParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull SimplePascalParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(@NotNull SimplePascalParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(@NotNull SimplePascalParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull SimplePascalParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull SimplePascalParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrfExpr(@NotNull SimplePascalParser.PrfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrfExpr(@NotNull SimplePascalParser.PrfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(@NotNull SimplePascalParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(@NotNull SimplePascalParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull SimplePascalParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull SimplePascalParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(@NotNull SimplePascalParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(@NotNull SimplePascalParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(@NotNull SimplePascalParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(@NotNull SimplePascalParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull SimplePascalParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull SimplePascalParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(@NotNull SimplePascalParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SimplePascalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(@NotNull SimplePascalParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void enterPrfOp(@NotNull SimplePascalParser.PrfOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void exitPrfOp(@NotNull SimplePascalParser.PrfOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(@NotNull SimplePascalParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(@NotNull SimplePascalParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(@NotNull SimplePascalParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(@NotNull SimplePascalParser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(@NotNull SimplePascalParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(@NotNull SimplePascalParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplePascalParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(@NotNull SimplePascalParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplePascalParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(@NotNull SimplePascalParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SimplePascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull SimplePascalParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link SimplePascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull SimplePascalParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SimplePascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull SimplePascalParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link SimplePascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull SimplePascalParser.BoolTypeContext ctx);
}