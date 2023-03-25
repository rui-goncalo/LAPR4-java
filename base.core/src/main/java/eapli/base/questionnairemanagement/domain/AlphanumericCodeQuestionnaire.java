package eapli.base.questionnairemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class AlphanumericCodeQuestionnaire implements ValueObject, Comparable<AlphanumericCodeQuestionnaire> {
    private String alphanumericCode;

    protected AlphanumericCodeQuestionnaire() {
    }

    public AlphanumericCodeQuestionnaire(String alphanumericCode) {
        if (alphanumericCode.length() > 15) {
            throw new IllegalArgumentException("Not a valid code. Max 15 chars.");
        }
        this.alphanumericCode = alphanumericCode;
    }

    public static AlphanumericCodeQuestionnaire valueOf(String alphanumericCode) {
        return new AlphanumericCodeQuestionnaire(alphanumericCode);
    }

    @Override
    public int compareTo(AlphanumericCodeQuestionnaire o) {
        return 0;
    }

    @Override
    public String toString() {
        return alphanumericCode;
    }
}
