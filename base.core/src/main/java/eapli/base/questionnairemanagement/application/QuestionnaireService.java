package eapli.base.questionnairemanagement.application;

import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.dto.QuestionnaireDTO;

public class QuestionnaireService {
    public QuestionnaireDTO toDTO(Questionnaire questionnaire) {
        return new QuestionnaireDTO(String.valueOf(questionnaire.getAlphanumericCode()), String.valueOf(questionnaire.getQuestionnaireDescription()), String.valueOf(questionnaire.getPeriod()));
    }
}
