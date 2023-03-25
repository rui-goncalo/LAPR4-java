// Generated from /Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Answer.g4 by ANTLR 4.10.1
package eapli.base.questionnairemanagement.domain.antlr4Answer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnswerParser}.
 */
public interface AnswerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnswerParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(AnswerParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(AnswerParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterAnswers(AnswerParser.AnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitAnswers(AnswerParser.AnswersContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(AnswerParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(AnswerParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#q_text}.
	 * @param ctx the parse tree
	 */
	void enterQ_text(AnswerParser.Q_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#q_text}.
	 * @param ctx the parse tree
	 */
	void exitQ_text(AnswerParser.Q_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#c_answer}.
	 * @param ctx the parse tree
	 */
	void enterC_answer(AnswerParser.C_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#c_answer}.
	 * @param ctx the parse tree
	 */
	void exitC_answer(AnswerParser.C_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void enterObligatoriness(AnswerParser.ObligatorinessContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void exitObligatoriness(AnswerParser.ObligatorinessContext ctx);
}