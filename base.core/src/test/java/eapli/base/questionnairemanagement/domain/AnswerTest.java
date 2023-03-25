package eapli.base.questionnairemanagement.domain;

import eapli.base.customermanagement.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class AnswerTest {
    Customer customer = new Customer(Name.valueOf("Tiago", "Pinto"), NameCustomer.valueOf("Tiago André Pinto"), GenderCustomer.valueOf("male"), PhoneCustomer.valueOf(351, 913913913), VATCustomer.valueOf("PT913913913"), "Maia", EmailAddress.valueOf("tpinto@emai.l.com"), BirthDateCustomer.valueOf(1997, 9, 13));
    Map<String, String> map = new HashMap<>();
    Answer answer = new Answer(AnswerID.valueOf(1), customer, map);

    @Test
    public void testGetAnswerID() {
        AnswerID answerID = AnswerID.valueOf(1);

        Assertions.assertEquals(answerID.toString(), answer.getAnswerID().toString());
    }

    @Test
    public void testSetAnswerID() {
        AnswerID answerID = AnswerID.valueOf(2);

        answer.setAnswerID(AnswerID.valueOf(2));
        Assertions.assertEquals(answerID.toString(), answer.getAnswerID().toString());
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer(Name.valueOf("Tiago", "Pinto"), NameCustomer.valueOf("Tiago André Pinto"), GenderCustomer.valueOf("male"), PhoneCustomer.valueOf(351, 913913913), VATCustomer.valueOf("PT913913913"), "Maia", EmailAddress.valueOf("tpinto@emai.l.com"), BirthDateCustomer.valueOf(1997, 9, 13));

        Assertions.assertEquals(customer.toString(), answer.getCustomer().toString());
    }

    @Test
    public void testSetCustomer() {
        Customer customer1 = new Customer(Name.valueOf("Tiago", "Andre"), NameCustomer.valueOf("Tiago André Pinto"), GenderCustomer.valueOf("male"), PhoneCustomer.valueOf(351, 913913913), VATCustomer.valueOf("PT913913913"), "Maia", EmailAddress.valueOf("tpinto@emai.l.com"), BirthDateCustomer.valueOf(1997, 9, 13));

        answer.setCustomer(customer1);
        Assertions.assertEquals(customer1.toString(), answer.getCustomer().toString());
    }

    @Test
    public void testGetAll_Answers() {
        map.put("Q1:", "25");
        map.put("Q2:", "25");
        map.put("Q3:", "male");
        map.put("Q4:", "Not Answered.");
        map.put("Q5:", "friends");

        Assertions.assertEquals(map.toString(), answer.getAll_answers().toString());
    }

    @Test
    public void testSetAll_Answers() {
        map.put("Q1:", "25");
        map.put("Q2:", "25");
        map.put("Q3:", "male");
        map.put("Q4:", "no");
        map.put("Q5:", "friends");

        answer.setAll_answers(map);
        Assertions.assertEquals(map.toString(), answer.getAll_answers().toString());
    }
}
