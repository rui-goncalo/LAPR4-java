package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class NameCustomer implements ValueObject, Comparable<EmailCustomer> {
    private String name;

    public NameCustomer() {
    }

    public NameCustomer(String name) {
        if (StringPredicates.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name can't be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static NameCustomer valueOf (final String nameCustomer) {
        return new NameCustomer(nameCustomer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameCustomer that = (NameCustomer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(EmailCustomer o) {
        return 0;
    }
}
