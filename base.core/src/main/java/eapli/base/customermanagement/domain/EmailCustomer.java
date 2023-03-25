package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class EmailCustomer implements ValueObject, Comparable<EmailCustomer> {
    private String email;

    public EmailCustomer() {
    }

    public EmailCustomer(String email) {
        if (StringPredicates.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("Email can't be null or empty.");
        }
        Preconditions.ensure(StringPredicates.isEmail(email), "Invalid email.");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static EmailCustomer valueOf (final String email) {
        return new EmailCustomer(email);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailCustomer)) {
            return false;
        }
        final EmailCustomer that = (EmailCustomer) o;
        return this.email.equalsIgnoreCase(that.email);
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public int compareTo(EmailCustomer o) {
        return this.email.compareTo(o.email);
    }

    @Override
    public String toString() {
        return this.email;
    }
}
