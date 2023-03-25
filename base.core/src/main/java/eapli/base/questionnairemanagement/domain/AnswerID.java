package eapli.base.questionnairemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerID implements ValueObject, Comparable<AnswerID> {
    private int id;

    protected AnswerID() {
    }

    public AnswerID(int id) {
        this.id = id;
    }

    public static AnswerID valueOf(int id) {
        return new AnswerID(id);
    }

    @Override
    public int compareTo(AnswerID o) {
        return 0;
    }

    @Override
    public String toString() {
        return "AnswerID{" +
                "id=" + id +
                '}';
    }
}
