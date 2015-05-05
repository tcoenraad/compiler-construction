// Generated from /Users/twancoenraad/Code/compiler-construction/block-2/pp/block2/cc/antlr/Sentence.g4 by ANTLR 4.5
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SentenceParser}.
 */
public interface SentenceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SentenceParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(@NotNull SentenceParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(@NotNull SentenceParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSubject(@NotNull SentenceParser.SubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSubject(@NotNull SentenceParser.SubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SentenceParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(@NotNull SentenceParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(@NotNull SentenceParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SentenceParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(@NotNull SentenceParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SentenceParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(@NotNull SentenceParser.ModifierContext ctx);
}