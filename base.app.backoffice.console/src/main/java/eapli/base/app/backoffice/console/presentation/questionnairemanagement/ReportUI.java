package eapli.base.app.backoffice.console.presentation.questionnairemanagement;

import eapli.base.questionnairemanagement.application.AnswerController;
import eapli.base.questionnairemanagement.application.ReportController;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ReportUI extends AbstractUI {
    private final AnswerController answerController = new AnswerController();
    private final ReportController reportController = new ReportController();

    @Override
    protected boolean doShow() {
        try {
            System.out.println("Questionnaires available to generate the report: \n");
            List<Questionnaire> questionnaires = answerController.findAllQuestionnaires();
            Integer[] report = new Integer[10];

            for (Questionnaire questionnaire : questionnaires) {
                System.out.println(questionnaire.toString());
            }

            String opt = Console.readNonEmptyLine("Choose the alphanumeric code: ", "Alphanumeric Code required.");
            System.out.println("+==============================================================================+");
            System.out.println("|                           REPORT QUESTIONNAIRE                               |");
            System.out.println("+==============================================================================+");
            report = reportController.getReport(opt);
            System.out.println("Number of questions: " + report[0]);
            System.out.println("Number of answers: " + report[1]);
            System.out.println("Percentage of answers: " + report[2] + "%");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public String headline() {
        return "report";
    }

}
