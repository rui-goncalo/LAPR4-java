package eapli.base.app.backoffice.console.presentation.ordermanagement;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.NewOrder;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class SalesClerkUpdateOrderUI extends AbstractUI {
    private final OrderController orderController = new OrderController();

    @Override
    protected boolean doShow() {
        try {
            System.out.println("We'll search all the orders with the status DISPATCHED_FOR_CUSTOMER_DELIVERY\n");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<NewOrder> newOrderList = orderController.findByStatus("DISPATCHED_FOR_CUSTOMER_DELIVERY");
        orderController.listAllOrders(newOrderList);

        String orderID = Console.readNonEmptyLine("\nChoose the order ID: ", "Order ID required.");
        NewOrder newOrder = orderController.findByID(orderID);

        System.out.println("Your order is now being delivered ...\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String status = "BEING_DELIVERED";
        System.out.println(orderController.updateOrder(newOrder, status));

        return true;
    }

    @Override
    public String headline() {
        return "Update a Order's status to BEING_DELIVERY";
    }
}
