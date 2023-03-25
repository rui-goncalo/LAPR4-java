package eapli.base.app.backoffice.console.presentation.ordermanagement;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.*;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class WarehouseUpdateOrderUI extends AbstractUI {
    private final OrderController orderController = new OrderController();

    @Override
    protected boolean doShow() {
        try {
            System.out.println("We'll search all the orders with the status ALREADY_BEEN_PREPARED_BY_THE_AGV\n");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<NewOrder> newOrderList = orderController.findByStatus("ALREADY_BEEN_PREPARED_BY_THE_AGV");
        orderController.listAllOrders(newOrderList);

        String orderID = Console.readNonEmptyLine("\nChoose the order ID: ", "Order ID required.");
        NewOrder newOrder = orderController.findByID(orderID);

        System.out.println("Your order will be now dispatched for customer delivery ...\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String status = "DISPATCHED_FOR_CUSTOMER_DELIVERY";
        System.out.println(orderController.updateOrder(newOrder, status));

        return true;
    }

    @Override
    public String headline() {
        return "Update a Order's status to DISPATCHED_FOR_CUSTOMER_DELIVERY";
    }
}
