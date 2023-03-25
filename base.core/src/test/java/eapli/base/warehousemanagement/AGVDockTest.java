package eapli.base.warehousemanagement;

import eapli.base.customermanagement.domain.*;
import eapli.base.ordermanagement.domain.*;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;

public class AGVDockTest {
    Customer customer = new Customer(Name.valueOf("Tiago", "Pinto"), NameCustomer.valueOf("Tiago André Pinto"), GenderCustomer.valueOf("male"), PhoneCustomer.valueOf(351, 913913913), VATCustomer.valueOf("PT913913913"), "Maia", EmailAddress.valueOf("tpinto@emai.l.com"), BirthDateCustomer.valueOf(1997, 9, 13));
    NewOrder order = new NewOrder(OrderID.valueOf("15"), Status.valueOf("REGISTERED"), Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer, PaymentMethod.APPLE_PAY, ShipmentType.GREEN, 3000.00);
    AGVDock agvDock = new AGVDock("D7", "l+", new Coordinates(10, 11), new Coordinates(12, 13), new Coordinates(14, 15), "Autonomous robots built to serve their human overlords", "AGV Dock 1.0", 150, 200, new Coordinates(16, 17), "Occupied", order);

    @Test
    public void testGetID() {
        String id = "D7";
        Assertions.assertEquals(id.toString(), agvDock.getId().toString(), "getID()");
    }

    @Test
    public void testGetAccessibility() {
        String access = "l+";
        Assertions.assertEquals(access.toString(), agvDock.getAccessibility().toString(), "testGetAccessibility()");
    }

    @Test
    public void testGetBegin() {
        Coordinates begin = new Coordinates(10, 11);
        Assertions.assertEquals(begin.toString(), agvDock.getBegin().toString(), "testGetBegin()");
    }

    @Test
    public void testGetEnd() {
        Coordinates end = new Coordinates(12, 13);
        Assertions.assertEquals(end.toString(), agvDock.getEnd().toString(), "testGetEnd()");
    }

    @Test
    public void testGetDepth() {
        Coordinates depth = new Coordinates(14, 15);
        Assertions.assertEquals(depth.toString(), agvDock.getDepth().toString(), "testGetDepth()");
    }

    @Test
    public void testGetBaseLocation() {
        Coordinates baselocation = new Coordinates(16, 17);
        Assertions.assertEquals(baselocation.toString(), agvDock.getBaseLocation().toString(), "testGetBaseLocation()");
    }

    @Test
    public void testGetDescription() {
        String description = "Autonomous robots built to serve their human overlords";
        Assertions.assertEquals(description.toString(), agvDock.getDescription().toString(), "testGetDescription()");
    }

    @Test
    public void testGetAGVModel() {
        String model = "AGV Dock 1.0";
        Assertions.assertEquals(model.toString(), agvDock.getAgvModel().toString(), "testGetAGVModel()");
    }

    @Test
    public void testGetCarryWeight() {
        float weight = 150;
        Assertions.assertEquals(weight, agvDock.getCarryWeight(), "testGetCarryWeight()");
    }

    @Test
    public void testGetMaxWeight() {
        float weight = 200;
        Assertions.assertEquals(weight, agvDock.getMaxWeight(), "testGetMaxWeight()");
    }

    @Test
    public void testGetState() {
        String state = "Occupied";
        Assertions.assertEquals(state.toString(), agvDock.getState().toString(), "testGetState()");
    }

    @Test
    public void testSetState() {
        String state = "Free";

        agvDock.setState(state);

        Assertions.assertEquals(state.toString(), agvDock.getState().toString(), "testSetState()");
    }

    @Test
    public void testGetOrder() {
        Assertions.assertEquals(order.toString(), agvDock.getOrder().toString(), "testGetOrder()");
    }

    @Test
    public void testSetOrder() {
        NewOrder newOrder = new NewOrder(OrderID.valueOf("20"), Status.valueOf("REGISTERED"), Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer, PaymentMethod.APPLE_PAY, ShipmentType.GREEN, 3500.00);

        agvDock.setOrder(newOrder);

        Assertions.assertEquals(newOrder.toString(), agvDock.getOrder().toString(), "testSetOrder()");
    }

}
