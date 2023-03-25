package eapli.base.questionnairemanagement.domain;

import eapli.base.questionnairemanagement.domain.antlr4Answer.AnswerBaseVisitor;
import eapli.base.questionnairemanagement.domain.antlr4Answer.AnswerParser;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EvalVisitorAnswer extends AnswerBaseVisitor<String> {
    List<String> answers = new ArrayList<>();

    @Override
    public String visitAnswers(AnswerParser.AnswersContext ctx) {
        Set<String> answers = new LinkedHashSet<>();

        for (AnswerParser.AnswerContext answerContexts : ctx.answer()) {
            answers.add(visitAnswer(answerContexts));
        }

        String res = "Answers: " + answers;

        return res;
    }

    @Override
    public String visitAnswer(AnswerParser.AnswerContext ctx) {
        String identifier = ctx.Q_ID().getText();
        System.out.println(identifier);
        String question = ctx.q_text().getText();
        System.out.println(question);
        String obligatoriness = ctx.obligatoriness().getText();
        String answer = ctx.c_answer().getText();
        System.out.println(answer);

        String res = "Q_ID: " + identifier +
                "\nQuestion: " + question +
                "\nObligatoriness: " + obligatoriness +
                "\nAnswer: " + answer;

        return res;
    }

    @Override
    public String visitQ_text(AnswerParser.Q_textContext ctx) {
        System.out.println("Question: " + ctx.getText());

        return super.visitQ_text(ctx);
    }
}
