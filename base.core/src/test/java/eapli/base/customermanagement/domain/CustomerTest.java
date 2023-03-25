package eapli.base.customermanagement.domain;

import eapli.base.ordermanagement.domain.OrderID;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CustomerTest {
    Customer customer = new Customer(Name.valueOf("Tiago", "Pinto"), NameCustomer.valueOf("Tiago André Pinto"), GenderCustomer.valueOf("male"), PhoneCustomer.valueOf(351, 913913913), VATCustomer.valueOf("PT913913913"), "Maia", EmailAddress.valueOf("tpinto@emai.l.com"), BirthDateCustomer.valueOf(1997, 9, 13));

    @Test
    public void testGetShortName() {
        Name shortName = Name.valueOf("Tiago", "Pinto");

        Assertions.assertEquals(shortName.toString(), customer.getShortName().toString(), "testGetShortName()");
    }

    @Test
    public void testSetShortName() {
        Name shortName = Name.valueOf("Tiago", "Andre");

        customer.setShortName(shortName);

        Assertions.assertEquals(shortName.toString(), customer.getShortName().toString(), "testSetShortName()");
    }

    @Test
    public void testGetName() {
        NameCustomer name = new NameCustomer("Tiago André Pinto");

        Assertions.assertEquals(name.toString(), customer.getName().toString(), "testGetName()");
    }

    @Test
    public void testSetName() {
        NameCustomer name = new NameCustomer("Tiago A. M. Pinto");

        customer.setName(name);

        Assertions.assertEquals(name.toString(), customer.getName().toString(), "testSetName()");
    }

    @Test
    public void testGetGender() {
        GenderCustomer gender = new GenderCustomer("male");

        Assertions.assertEquals(gender.toString(), customer.getGender().toString(), "testGetGender()");
    }

    @Test
    public void testSetGender() {
        GenderCustomer gender = new GenderCustomer("malemale");

        customer.setGender(gender);

        Assertions.assertEquals(gender.toString(), customer.getGender().toString(), "testSetGender()");
    }

    @Test
    public void testGetPhone() {
        PhoneCustomer phone = new PhoneCustomer(351, 913913913);

        Assertions.assertEquals(phone.toString(), customer.getPhone().toString(), "testGetPhone()");
    }

    @Test
    public void testSetPhone() {
        PhoneCustomer phone = new PhoneCustomer(351, 999999999);

        customer.setPhone(phone);

        Assertions.assertEquals(phone.toString(), customer.getPhone().toString(), "testSetPhone()");
    }

    @Test
    public void testGetVAT() {
        VATCustomer vat = new VATCustomer("PT913913913");

        Assertions.assertEquals(vat.toString(), customer.getVat().toString(), "testGetVAT()");
    }

    @Test
    public void testSetVAT() {
        VATCustomer vat = new VATCustomer("PT999999999");

        customer.setVat(vat);

        Assertions.assertEquals(vat.toString(), customer.getVat().toString(), "testSetVAT()");
    }

    @Test
    public void testGetAddress() {
        String address = "Maia";

        Assertions.assertEquals(address.toString(), customer.getPostalAddress().toString(), "testGetAddress()");
    }

    @Test
    public void testSetAddress() {
        String address = "Maia, Porto";

        customer.setPostalAddress(address);

        Assertions.assertEquals(address.toString(), customer.getPostalAddress().toString(), "testSetAddress()");
    }

    @Test
    public void testGetEmail() {
        EmailAddress emailAddress = EmailAddress.valueOf("tpinto@emai.l.com");

        Assertions.assertEquals(emailAddress.toString(), customer.getEmail().toString(), "testGetEmail()");
    }

    @Test
    public void testSetEmail() {
        EmailAddress emailAddress = EmailAddress.valueOf("tamp@emai.l.com");

        customer.setEmail(emailAddress);

        Assertions.assertEquals(emailAddress.toString(), customer.getEmail().toString(), "testSetEmail()");
    }

    @Test
    public void testGetBirthDate() {
        BirthDateCustomer birthDateCustomer = new BirthDateCustomer(1997, 9, 13);

        Assertions.assertEquals(birthDateCustomer.toString(), customer.getBirthDate().toString(), "testGetBirthDate()");
    }

    @Test
    public void testSetBirthDate() {
        BirthDateCustomer birthDateCustomer = new BirthDateCustomer(1990, 1, 1);

        customer.setBirthDate(birthDateCustomer);

        Assertions.assertEquals(birthDateCustomer.toString(), customer.getBirthDate().toString(), "testSetBirthDate()");
    }

    @Test
    public void getToString() {
        String exp = "Customer: " +
                "\nShort Name = " + customer.getShortName() +
                ",\nName = " + customer.getName() +
                ",\nGender = " + customer.getGender() +
                ",\nPhone = " + customer.getPhone() +
                ",\nVAT = " + customer.getVat() +
                ",\nPostal Address = '" + customer.getPostalAddress() + '\'' +
                ",\nEmail = " + customer.getEmail() +
                ",\nBirth Date = " + customer.getBirthDate();

        Assertions.assertEquals(exp, customer.toString(), "getToString()");
    }

}
