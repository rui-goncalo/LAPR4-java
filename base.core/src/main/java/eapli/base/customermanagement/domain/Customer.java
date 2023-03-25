package eapli.base.customermanagement.domain;

import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement
@Entity
public class Customer implements AggregateRoot<Integer>, Serializable {
    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue
    private Integer pk;

    @Embedded
    @Column(nullable = false)
    private Name shortName;
    @Embedded
    @Column(nullable = false)
    private NameCustomer name;
    @Embedded
    private GenderCustomer gender;
    @Embedded
    @Column(unique = true, nullable = false)
    private PhoneCustomer phone;
    @Embedded
    private VATCustomer vat;
    private String postalAddress;
    @Embedded
    @Column(unique = true, nullable = false)
    private EmailAddress email;
    @Embedded
    private BirthDateCustomer birthDate;

    protected Customer() {
    }

    /**
     * Instantiates a new Customer
     * @param name
     * @param gender
     * @param phone
     * @param vat
     * @param postalAddress
     * @param email
     * @param birthDate
     */
    public Customer(Name shortName, NameCustomer name, GenderCustomer gender, PhoneCustomer phone, VATCustomer vat, String postalAddress, EmailAddress email, BirthDateCustomer birthDate) {
        Preconditions.nonNull(shortName);
        Preconditions.nonNull(name);
        Preconditions.nonNull(phone);
        Preconditions.nonNull(email);
        //TODO
        //Preconditions.ensure(fullNameMeetsMinimumRequirements(fullName));
        this.shortName = shortName;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.vat = vat;
        this.postalAddress = postalAddress;
        this.email = email;
        this.birthDate = birthDate;
    }

    //TODO
//    private boolean shortNameMeetsMinimumRequirements(final String name) {
//        return !StringPredicates.isNullOrEmpty(name);
//    }

    public Name getShortName() {
        return shortName;
    }

    public void setShortName(Name shortName) {
        this.shortName = shortName;
    }

    public NameCustomer getName() {
        return name;
    }

    public void setName(NameCustomer name) {
        this.name = name;
    }

    public GenderCustomer getGender() {
        return gender;
    }

    public void setGender(GenderCustomer gender) {
        this.gender = gender;
    }

    public PhoneCustomer getPhone() {
        return phone;
    }

    public void setPhone(PhoneCustomer phone) {
        this.phone = phone;
    }

    public VATCustomer getVat() {
        return vat;
    }

    public void setVat(VATCustomer vat) {
        this.vat = vat;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public BirthDateCustomer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(BirthDateCustomer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Customer)) {
            return false;
        }

        final Customer that = (Customer) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public String toString() {
        return "Customer: " +
                "\nShort Name = " + shortName +
                ",\nName = " + name +
                ",\nGender = " + gender +
                ",\nPhone = " + phone +
                ",\nVAT = " + vat +
                ",\nPostal Address = '" + postalAddress + '\'' +
                ",\nEmail = " + email +
                ",\nBirth Date = " + birthDate;
    }

    @Override
    public Integer identity() {
        return this.pk;
    }
}
