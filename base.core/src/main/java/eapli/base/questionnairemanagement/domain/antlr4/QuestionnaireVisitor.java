// Generated from /Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnairemanagement.domain.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionnaireParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionnaireVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(QuestionnaireParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#welcome_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWelcome_message(QuestionnaireParser.Welcome_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#final_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinal_message(QuestionnaireParser.Final_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#sdescription}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdescription(QuestionnaireParser.SdescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#q_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ_text(QuestionnaireParser.Q_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#qinstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQinstruction(QuestionnaireParser.QinstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#qtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQtype(QuestionnaireParser.QtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#free_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree_text(QuestionnaireParser.Free_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#numeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(QuestionnaireParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#single_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_choice(QuestionnaireParser.Single_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#multiple_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice(QuestionnaireParser.Multiple_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#opts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpts(QuestionnaireParser.OptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#opt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt(QuestionnaireParser.OptContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(QuestionnaireParser.ObligatorinessContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#extra_info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtra_info(QuestionnaireParser.Extra_infoContext ctx);
}