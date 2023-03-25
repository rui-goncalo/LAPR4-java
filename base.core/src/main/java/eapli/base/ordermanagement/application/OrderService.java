package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.io.util.Console;

import java.util.List;

@ApplicationService
public class OrderService {
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();

    public int showPaymentMethods() {
        int option = -1;

        System.out.println("===========================================");
        System.out.println("               Payment Methods:          ");
        System.out.println("===========================================\n");
        System.out.println("1 - PAYPAL");
        System.out.println("2 - APPLE PAY");
        System.out.println("3 - CREDIT CARD");
        System.out.println("4 - BANK TRANSFER");
        System.out.println("===========================================");
        System.out.println("0. Back\n");

        option = Console.readInteger("\nPlease choose the payment method.");

        return option;
    }

    public PaymentMethod paymentMethod(int options) {

        switch (options) {
            case (1):
                return PaymentMethod.PAYPAL;
            case (2):
                return PaymentMethod.APPLE_PAY;
            case (3):
                return PaymentMethod.CREDIT_CARD;
            case (4):
                return PaymentMethod.BANK_TRANSFER;
        }

        return null;
    }

    public int showShipmentMethods() {
        int option = -1;

        System.out.println("===========================================");
        System.out.println("               Shipment Type:          ");
        System.out.println("===========================================\n");
        System.out.println("1 - STANDARD");
        System.out.println("2 - BLUE");
        System.out.println("3 - GREEN");
        System.out.println("===========================================");
        System.out.println("0. Back\n");

        option = Console.readInteger("\nPlease choose the shipment method.");

        return option;
    }

    public ShipmentType shipmentType(int options) {
        switch (options) {
            case (1):
                return ShipmentType.STANDARD;
            case (2):
                return ShipmentType.BLUE;
            case (3):
                return ShipmentType.GREEN;
        }

        return null;
    }

    public ShipmentCost shipmentCostMethod(ShipmentType type) {
        ShipmentCost cost = null;
        if (type.equals(ShipmentType.STANDARD)) {
            cost = new ShipmentCost(1.15);
        } else {
            if (type.equals(ShipmentType.BLUE)) {
                cost = new ShipmentCost(1.70);
            } else {
                if (type.equals(ShipmentType.GREEN)) {
                    cost = new ShipmentCost(4.05);
                }
            }
        }

        return cost;
    }

    public void printListOrders (List<NewOrder> orderList) {
        for (NewOrder o : orderList) {
            System.out.println(o.getOrderID().toString() +
                    "\n" + o.getCustomer().toString() +
                    "\nStatus: " + o.getStatus() + "\n");
        }
    }

    public void printOrder (NewOrder o) {
        System.out.println(o.getOrderID() +
                "\n" + o.getCustomer().toString() +
                "\nStatus: " + o.getStatus() + "\n");
    }
}
