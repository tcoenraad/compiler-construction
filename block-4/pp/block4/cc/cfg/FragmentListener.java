// Generated from Fragment.g4 by ANTLR 4.4
package pp.block4.cc.cfg;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FragmentParser}.
 */
public interface FragmentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(@NotNull FragmentParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContStat(@NotNull FragmentParser.ContStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContStat(@NotNull FragmentParser.ContStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull FragmentParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull FragmentParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(@NotNull FragmentParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(@NotNull FragmentParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FragmentParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull FragmentParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FragmentParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull FragmentParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FragmentParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull FragmentParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FragmentParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull FragmentParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull FragmentParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull FragmentParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayTarget(@NotNull FragmentParser.ArrayTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayTarget(@NotNull FragmentParser.ArrayTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull FragmentParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull FragmentParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpr(@NotNull FragmentParser.BitAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpr(@NotNull FragmentParser.BitAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull FragmentParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull FragmentParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull FragmentParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull FragmentParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(@NotNull FragmentParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FragmentParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(@NotNull FragmentParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(@NotNull FragmentParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(@NotNull FragmentParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(@NotNull FragmentParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(@NotNull FragmentParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull FragmentParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull FragmentParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(@NotNull FragmentParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(@NotNull FragmentParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFieldExpr(@NotNull FragmentParser.FieldExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFieldExpr(@NotNull FragmentParser.FieldExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpr(@NotNull FragmentParser.BitOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpr(@NotNull FragmentParser.BitOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull FragmentParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull FragmentParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull FragmentParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull FragmentParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(@NotNull FragmentParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FragmentParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(@NotNull FragmentParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(@NotNull FragmentParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(@NotNull FragmentParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(@NotNull FragmentParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(@NotNull FragmentParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull FragmentParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FragmentParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull FragmentParser.AndExprContext ctx);
}