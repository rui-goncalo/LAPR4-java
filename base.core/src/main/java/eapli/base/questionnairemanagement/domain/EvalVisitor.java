package eapli.base.questionnairemanagement.domain;

import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireBaseVisitor;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireParser;
import eapli.framework.io.util.Console;

import java.util.*;

public class EvalVisitor extends QuestionnaireBaseVisitor<String> {
    List<String> answers = new ArrayList<>();

    @Override
    public String visitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx) {
        String identifier = ctx.QID().getText();
        String title = ctx.QTITLE().getText();
        String welcome_message = ctx.welcome_message().getText();
        Set<String> sections = new LinkedHashSet<>();

        for (QuestionnaireParser.SectionContext sectionContext : ctx.section()) {
            sections.add(visitSection(sectionContext));
        }

        String final_message = ctx.final_message().getText();

        String res = "QID: " + identifier +
                "\nQTitle: " + title +
                "\nWelcome Message: " + welcome_message +
                "\nSections: " + sections +
                "\nFinal Message: " + final_message;


        System.out.println("Your answers:");
        for (String str : answers) {
            System.out.println(str);
        }
        answers.add("\n");

        AnswerWriter answerWriter = new AnswerWriter();

        for (String str : answers) {
            AnswerWriter.answerFile(str);
        }

        return res;
    }

    @Override
    public String visitSection(QuestionnaireParser.SectionContext ctx) {
        String identifier = ctx.SID().getText();
        String title = ctx.STITLE().getText();
        String description = ctx.sdescription().getText();
        String obligatoriness = ctx.obligatoriness().getText();
        Set<String> questions = new LinkedHashSet<>();
        for (QuestionnaireParser.QuestionContext questionContext : ctx.question()) {
            questions.add(visitQuestion(questionContext));
        }
        String res = "SID: " + identifier +
                "\nSTitle: " + title +
                "\nDescription: " + description +
                "\nObligatoriness: " + obligatoriness +
                "\nQuestions: " + questions;

        return res;
    }

    @Override
    public String visitQuestion(QuestionnaireParser.QuestionContext ctx) {
        String answer;
        boolean flag_mc = false;

        String identifier = ctx.Q_ID().getText();
        String question = ctx.q_text().getText();
        String instruction = ctx.qinstruction().getText();
        String obligatoriness = ctx.obligatoriness().getText();
        String extra_info = ctx.extra_info().getText();
        String type = ctx.qtype().getText();

        if (obligatoriness.contains("Mandatory")) {
            System.out.println(identifier);
            System.out.println(question);
            if (type.contains("Multiple-choice")) {
                visitQtype(ctx.qtype());
                flag_mc = true;
                answers.add(identifier);
                answers.add(question);
                answers.add(obligatoriness);
                answers.add(type);
            } else if (type.contains("Single-choice")) {
                visitQtype(ctx.qtype());
                answers.add(identifier);
                answers.add(question);
                answers.add(obligatoriness);
                answers.add(type);
                answer = Console.readLine("Answer: ");
                answers.add(answer);
            } else {
                answers.add(identifier);
                answers.add(question);
                answers.add(obligatoriness);
                answers.add(type);
                answer = Console.readLine("Answer: ");
                answers.add(answer);
            }
        } else {
            System.out.println(identifier);
            System.out.println(question);
            System.out.println(obligatoriness);
            String yn = Console.readLine("Do you want to answer this question? (yes/no)");
            if (yn.equals("no")) {
                answers.add(identifier);
                answers.add(question);
                answers.add(obligatoriness);
                answers.add(type);
                System.out.println("Not answered.");
                answers.add("Not answered.");
            } else {
                if (type.contains("Multiple-choice")) {
                    visitQtype(ctx.qtype());
                    flag_mc = true;
                    answers.add(identifier);
                    answers.add(question);
                    answers.add(obligatoriness);
                    answers.add(type);
                } else if (type.contains("Single-choice")) {
                    visitQtype(ctx.qtype());
                    answers.add(identifier);
                    answers.add(question);
                    answers.add(obligatoriness);
                    answers.add(type);
                    answer = Console.readLine("Answer: ");
                    answers.add(answer);
                } else {
                    answers.add(identifier);
                    answers.add(question);
                    answers.add(obligatoriness);
                    answers.add(type);
                    answer = Console.readLine("Answer: ");
                    answers.add(answer);
                }
            }
        }

        if (flag_mc) {
            boolean flag = true;
            do {
                String res1 = Console.readLine("Answer: ");
                answers.add(res1);
                String option = Console.readLine("Do you want to add another option? (yes/no)");
                if (option.equals("no")) {
                    flag = false;
                } else {
                    flag = true;
                }
            } while (flag);
        }

        String res = "Q_ID: " + identifier +
                "\nText: " + question +
                "\nInstruction: " + instruction +
                "\nObligatoriness: " + obligatoriness +
                "\nExtra Info: " + extra_info +
                "\nType: " + type;

        return res;
    }

    @Override
    public String visitQtype(QuestionnaireParser.QtypeContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();

        if (ctx.getText().contains("Single-choice")) {
            for (QuestionnaireParser.OptContext optContext : ctx.single_choice().opt()) {
                System.out.println(optContext.getText());
            }
        } else if (ctx.getText().contains("Multiple-choice")) {
            for (QuestionnaireParser.OptContext optContext : ctx.multiple_choice().opt()) {
                System.out.println(optContext.getText());
            }
        }

        return null;
    }

    @Override
    public String visitOpt(QuestionnaireParser.OptContext ctx) {
        String identifier = ctx.SID().getText();
        String text = ctx.PHRASE().getText();

        String res = "ID: " + identifier +
                "\nText: " + text;

        return res;
    }
}
