package eapli.base.questionnairemanagement.dto;

import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.PeriodQuestionnaire;
import eapli.framework.general.domain.model.Description;
import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
public class QuestionnaireDTO {
    private String alphanumericCode;
    private String description;
    private String period;

    public QuestionnaireDTO(String alphanumericCode, String description, String period) {
        this.alphanumericCode = alphanumericCode;
        this.description = description;
        this.period = period;
    }

    @Override
    public String toString() {
        return "Questionnaire: " +
                "\nAlphanumeric Code = " + alphanumericCode +
                "\nDescription = " + description +
                "\nAvailable for " + period + " days";
    }
}
