package eapli.base.questionnairemanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Answer implements AggregateRoot<AnswerID> {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private AnswerID answerID;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ElementCollection
    Map<String, String> all_answers;

    protected Answer() {
    }

    public Answer(AnswerID answerID, Customer customer, Map<String, String> all_answers) {
        this.answerID = answerID;
        this.customer = customer;
        this.all_answers = all_answers;
    }

    public Answer(Customer customer, Map<String, String> all_answers) {
        this.customer = customer;
        this.all_answers = all_answers;
    }

    public AnswerID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(AnswerID answerID) {
        this.answerID = answerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<String, String> getAll_answers() {
        return all_answers;
    }

    public void setAll_answers(Map<String, String> all_answers) {
        this.all_answers = all_answers;
    }

    @Override
    public String toString() {
        return "Answer: " +
                "\nAnswerID = " + answerID +
                "\nCustomer = " + customer +
                "\nAll_answers = " + all_answers;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public AnswerID identity() {
        return null;
    }
}
