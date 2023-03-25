package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.*;
import eapli.base.ordermanagement.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;

public class NewOrderTest {

    Customer customer = new Customer(Name.valueOf("Tiago", "Pinto"), NameCustomer.valueOf("Tiago André Pinto"), GenderCustomer.valueOf("male"), PhoneCustomer.valueOf(351, 913913913), VATCustomer.valueOf("PT913913913"), "Maia", EmailAddress.valueOf("tpinto@emai.l.com"), BirthDateCustomer.valueOf(1997, 9, 13));
    NewOrder order = new NewOrder(OrderID.valueOf("15"),Status.valueOf("REGISTERED"), Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer, PaymentMethod.APPLE_PAY, ShipmentType.GREEN, 3000.00);

    @Test
    public void testGetOrderID() {
        OrderID test = new OrderID("15");

        Assertions.assertEquals(test.toString(), order.getOrderID().toString(), "getOrderID()");
    }

    @Test
    public void testGetStatus() {
        Assertions.assertEquals(Status.REGISTERED.toString(), order.getStatus().toString(), "getStatus()");
    }

    @Test
    public void testGetClerk() {
        OrderClerk orderClerk = new OrderClerk(OrderClerk.Role.SALES_CLERK);
        Assertions.assertEquals(orderClerk.toString(), order.getClerk().toString(), "getClerk()");
    }

    @Test
    public void testGetCustomer() {
        Assertions.assertEquals(customer.toString(), order.getCustomer().toString(), "getCustomer()");
    }

    @Test
    public void testGetPaymentMethod() {
        Assertions.assertEquals(PaymentMethod.APPLE_PAY.toString(), order.getPayment_method().toString(), "testGetPaymentMethod()");
    }

    @Test
    public void testGetShipment() {
        Assertions.assertEquals(ShipmentType.GREEN.toString(), order.getShipment().toString(), "testGetShipment()");
    }

    @Test
    public void testSetStatus() {
        order.setStatus(Status.DELIVERED);
        Assertions.assertEquals(Status.DELIVERED.toString(), order.getStatus().toString()   , "testSetStatus()");
    }

    @Test
    public void getToString() {
        String exp = "Order: " +
                "\nOrder ID = " + order.getOrderID() +
                "\nStatus = " + order.getStatus() +
                "\nDate = " + order.getDate() +
                "\nClerk = " + order.getClerk() +
                "\nCustomer = " + customer +
                "\nPayment Method = " + order.getPayment_method() +
                "\nShipment = " + order.getShipment();

        Assertions.assertEquals(exp, order.toString(), "getToString()");
    }

}
