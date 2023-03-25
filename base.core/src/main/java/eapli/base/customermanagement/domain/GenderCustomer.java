package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class GenderCustomer implements ValueObject, Comparable<EmailCustomer> {
    private String gender;

    public GenderCustomer() {
    }

    public GenderCustomer(String gender) {
        if (StringPredicates.isNullOrEmpty(gender)) {
            throw new IllegalArgumentException("Gender can't be null or empty.");
        }
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static GenderCustomer valueOf (final String gender) {
        return new GenderCustomer(gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenderCustomer that = (GenderCustomer) o;
        return Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public int compareTo(EmailCustomer o) {
        return 0;
    }

    @Override
    public String toString() {
        return this.gender;
    }
}
