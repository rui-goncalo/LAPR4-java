// Generated from /Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Answer.g4 by ANTLR 4.10.1
package eapli.base.questionnairemanagement.domain.antlr4Answer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnswerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnswerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnswerParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(AnswerParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(AnswerParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(AnswerParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#q_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ_text(AnswerParser.Q_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#c_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_answer(AnswerParser.C_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(AnswerParser.ObligatorinessContext ctx);
}