package eapli.base.questionnairemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PeriodQuestionnaire implements ValueObject {
    private int period;

    protected PeriodQuestionnaire() {
    }

    public PeriodQuestionnaire(int period) {
        this.period = period;
    }

    public static PeriodQuestionnaire valueOf(int period) {
        return new PeriodQuestionnaire(period);
    }

    @Override
    public String toString() {
        return period + "";
    }
}
