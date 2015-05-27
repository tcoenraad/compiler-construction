// Generated from ILOC.g4 by ANTLR 4.4
package pp.iloc.parse;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILOCParser}.
 */
public interface ILOCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILOCParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull ILOCParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull ILOCParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#sources}.
	 * @param ctx the parse tree
	 */
	void enterSources(@NotNull ILOCParser.SourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#sources}.
	 * @param ctx the parse tree
	 */
	void exitSources(@NotNull ILOCParser.SourcesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instrList}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterInstrList(@NotNull ILOCParser.InstrListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instrList}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitInstrList(@NotNull ILOCParser.InstrListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comment}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void enterComment(@NotNull ILOCParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comment}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void exitComment(@NotNull ILOCParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realOp}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void enterRealOp(@NotNull ILOCParser.RealOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realOp}
	 * labeled alternative in {@link ILOCParser#op}.
	 * @param ctx the parse tree
	 */
	void exitRealOp(@NotNull ILOCParser.RealOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#opCode}.
	 * @param ctx the parse tree
	 */
	void enterOpCode(@NotNull ILOCParser.OpCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#opCode}.
	 * @param ctx the parse tree
	 */
	void exitOpCode(@NotNull ILOCParser.OpCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ILOCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ILOCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleInstr}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterSingleInstr(@NotNull ILOCParser.SingleInstrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleInstr}
	 * labeled alternative in {@link ILOCParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitSingleInstr(@NotNull ILOCParser.SingleInstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull ILOCParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull ILOCParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#targets}.
	 * @param ctx the parse tree
	 */
	void enterTargets(@NotNull ILOCParser.TargetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#targets}.
	 * @param ctx the parse tree
	 */
	void exitTargets(@NotNull ILOCParser.TargetsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILOCParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(@NotNull ILOCParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILOCParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(@NotNull ILOCParser.OperandContext ctx);
}