package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PhoneCustomer implements ValueObject, Comparable<EmailCustomer> {
    private String extension, phone;

    public PhoneCustomer() {
    }

    public PhoneCustomer(int extension, int phone) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(extension))) {
            this.extension = "351";
        }
        if (StringPredicates.isNullOrEmpty(String.valueOf(phone))) {
            throw new IllegalArgumentException("Phone can't be null or empty.");
        }
        if (String.valueOf(phone).length() != 9) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
        if (String.valueOf(extension).length() != 3 && !String.valueOf(extension).isEmpty()) {
            throw new IllegalArgumentException("Invalid extension.");
        }
        this.phone = String.valueOf(phone);
        this.extension = String.valueOf(extension);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = String.valueOf(phone);
    }

    public static PhoneCustomer valueOf (final int extension, final int phone) {
        return new PhoneCustomer(extension, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneCustomer that = (PhoneCustomer) o;
        return phone == that.phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }

    @Override
    public int compareTo(EmailCustomer o) {
        return 0;
    }

    @Override
    public String toString() {
        return "+" + this.extension + this.phone;
    }
}
