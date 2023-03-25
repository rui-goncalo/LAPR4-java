package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.Period;

@Embeddable
public class BirthDateCustomer implements ValueObject {
    private LocalDate birthdate;
    private int age;

    public BirthDateCustomer(int year, int month, int day) {
        if (year > 2006 || year < 1900){
            throw new IllegalArgumentException("Not a valid age.");
        }
        this.birthdate = LocalDate.of(year, month, day);
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();

        Period period = Period.between(birthdate, now);
        this.age = period.getYears();
    }

    protected BirthDateCustomer() {

    }

    public static BirthDateCustomer valueOf(int year, int month, int day) {
        return new BirthDateCustomer(year, month, day);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BirthDateCustomer)) {
            return false;
        }

        final BirthDateCustomer that = (BirthDateCustomer) o;
        return this.birthdate.equals(that.birthdate);
    }

    @Override
    public int hashCode() {
        return this.birthdate.hashCode();
    }

    @Override
    public String toString() {
        return "" + birthdate ;
    }
}
