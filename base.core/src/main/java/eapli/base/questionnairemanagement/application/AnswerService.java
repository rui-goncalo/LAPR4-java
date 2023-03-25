package eapli.base.questionnairemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.repositories.AnswerRepository;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;

import java.util.List;

public class AnswerService {
    public void showAllQuestionnaires(List<Questionnaire> questionnaires) {
        for (Questionnaire q : questionnaires) {
            System.out.println("Alphanumeric Code: " + q.getAlphanumericCode().toString() +
                    "\nDescription: " + q.getQuestionnaireDescription().toString() +
                    "\nAvailable for " + q.getPeriod() + " days\n\n");
        }
    }

    public String findPathByAlphanumericCode(String alphanumericcode) {
        if (alphanumericcode.equals("COSM22-01")) {
            return "/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire1.txt";
        } else if (alphanumericcode.equals("FUT22-01")) {
            return "/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire2.txt";
        } else if (alphanumericcode.equals("SCMED22-01")) {
            return "/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire3.txt";
        }
        return null;
    }
}
