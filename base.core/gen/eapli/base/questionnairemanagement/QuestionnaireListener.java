// Generated from /Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnairemanagement;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionnaireParser}.
 */
public interface QuestionnaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(QuestionnaireParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(QuestionnaireParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#welcome_message}.
	 * @param ctx the parse tree
	 */
	void enterWelcome_message(QuestionnaireParser.Welcome_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#welcome_message}.
	 * @param ctx the parse tree
	 */
	void exitWelcome_message(QuestionnaireParser.Welcome_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#final_message}.
	 * @param ctx the parse tree
	 */
	void enterFinal_message(QuestionnaireParser.Final_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#final_message}.
	 * @param ctx the parse tree
	 */
	void exitFinal_message(QuestionnaireParser.Final_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#sdescription}.
	 * @param ctx the parse tree
	 */
	void enterSdescription(QuestionnaireParser.SdescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#sdescription}.
	 * @param ctx the parse tree
	 */
	void exitSdescription(QuestionnaireParser.SdescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#q_text}.
	 * @param ctx the parse tree
	 */
	void enterQ_text(QuestionnaireParser.Q_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#q_text}.
	 * @param ctx the parse tree
	 */
	void exitQ_text(QuestionnaireParser.Q_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#qinstruction}.
	 * @param ctx the parse tree
	 */
	void enterQinstruction(QuestionnaireParser.QinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#qinstruction}.
	 * @param ctx the parse tree
	 */
	void exitQinstruction(QuestionnaireParser.QinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#qtype}.
	 * @param ctx the parse tree
	 */
	void enterQtype(QuestionnaireParser.QtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#qtype}.
	 * @param ctx the parse tree
	 */
	void exitQtype(QuestionnaireParser.QtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#free_text}.
	 * @param ctx the parse tree
	 */
	void enterFree_text(QuestionnaireParser.Free_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#free_text}.
	 * @param ctx the parse tree
	 */
	void exitFree_text(QuestionnaireParser.Free_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#numeric}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(QuestionnaireParser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#numeric}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(QuestionnaireParser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#single_choice}.
	 * @param ctx the parse tree
	 */
	void enterSingle_choice(QuestionnaireParser.Single_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#single_choice}.
	 * @param ctx the parse tree
	 */
	void exitSingle_choice(QuestionnaireParser.Single_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice(QuestionnaireParser.Multiple_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice(QuestionnaireParser.Multiple_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#opts}.
	 * @param ctx the parse tree
	 */
	void enterOpts(QuestionnaireParser.OptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#opts}.
	 * @param ctx the parse tree
	 */
	void exitOpts(QuestionnaireParser.OptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#opt}.
	 * @param ctx the parse tree
	 */
	void enterOpt(QuestionnaireParser.OptContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#opt}.
	 * @param ctx the parse tree
	 */
	void exitOpt(QuestionnaireParser.OptContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void enterObligatoriness(QuestionnaireParser.ObligatorinessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void exitObligatoriness(QuestionnaireParser.ObligatorinessContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#extra_info}.
	 * @param ctx the parse tree
	 */
	void enterExtra_info(QuestionnaireParser.Extra_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#extra_info}.
	 * @param ctx the parse tree
	 */
	void exitExtra_info(QuestionnaireParser.Extra_infoContext ctx);
}