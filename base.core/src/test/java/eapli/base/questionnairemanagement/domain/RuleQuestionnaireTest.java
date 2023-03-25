package eapli.base.questionnairemanagement.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RuleQuestionnaireTest {
    RulesQuestionnaire rulesQuestionnaire = new RulesQuestionnaire(18, "male");
    @Test
    public void testGetMinimum_Age() {
        int age = 18;

        Assertions.assertEquals(age, rulesQuestionnaire.getMinimum_age());
    }

    @Test
    public void testSetMinimum_Age() {
        int age = 20;
        rulesQuestionnaire.setMinimum_age(age);

        Assertions.assertEquals(age, rulesQuestionnaire.getMinimum_age());
    }

    @Test
    public void testGetGender() {
        String gender = "male";

        Assertions.assertEquals(gender, rulesQuestionnaire.getGender());
    }

    @Test
    public void testSetGender() {
        String gender = "other";
        rulesQuestionnaire.setGender(gender);

        Assertions.assertEquals(gender, rulesQuestionnaire.getGender());
    }
}
