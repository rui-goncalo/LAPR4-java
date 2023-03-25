package eapli.base.questionnairemanagement.domain;

import eapli.framework.general.domain.model.Description;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class QuestionnaireTest {
    String path = "/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/antlr4/Questionnaire1.txt";
    File questionnaire_file = new File(path);
    byte[] file = new byte[(int) questionnaire_file.length()];
    Questionnaire questionnaire = new Questionnaire(AlphanumericCodeQuestionnaire.valueOf("COSM22-01"), Description.valueOf("Football Questionnaire"), PeriodQuestionnaire.valueOf(30), file);

    @Test
    public void testGetAlphanumericCode() {
        AlphanumericCodeQuestionnaire alphanumericCodeQuestionnaire = AlphanumericCodeQuestionnaire.valueOf("COSM22-01");

        Assertions.assertEquals(alphanumericCodeQuestionnaire.toString(), questionnaire.getAlphanumericCode().toString(), "testGetAlphanumericCode()");
    }

    @Test
    public void testGetDescription() {
        Description description = Description.valueOf("Football Questionnaire");

        Assertions.assertEquals(description.toString(), questionnaire.getQuestionnaireDescription().toString(), "testGetDescription()");
    }

    @Test
    public void testGetPeriod() {
        PeriodQuestionnaire periodQuestionnaire = PeriodQuestionnaire.valueOf(30);

        Assertions.assertEquals(periodQuestionnaire.toString(), questionnaire.getPeriod().toString(), "testGetPeriod()");
    }

    @Test
    public void testSetAlphanumericCode() {
        AlphanumericCodeQuestionnaire alphanumericCodeQuestionnaire = AlphanumericCodeQuestionnaire.valueOf("COSMETIC22-01");
        questionnaire.setAlphanumericCode(alphanumericCodeQuestionnaire);

        Assertions.assertEquals(alphanumericCodeQuestionnaire.toString(), questionnaire.getAlphanumericCode().toString(), "testSetAlphanumericCode()");
    }

    @Test
    public void testSetDescription() {
        Description description = Description.valueOf("Cosmetic Questionnaire");
        questionnaire.setQuestionnaireDescription(description);

        Assertions.assertEquals(description.toString(), questionnaire.getQuestionnaireDescription().toString(), "testSetDescription()");
    }

    @Test
    public void testSetPeriod() {
        PeriodQuestionnaire periodQuestionnaire = PeriodQuestionnaire.valueOf(15);
        questionnaire.setPeriod(periodQuestionnaire);

        Assertions.assertEquals(periodQuestionnaire.toString(), questionnaire.getPeriod().toString(), "testSetPeriod()");
    }

}
