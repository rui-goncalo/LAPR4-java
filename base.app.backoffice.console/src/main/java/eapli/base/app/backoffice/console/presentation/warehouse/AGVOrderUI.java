package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.ordermanagement.domain.Status;
import eapli.base.warehousemanagement.application.ListAGVDockController;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class AGVOrderUI extends AbstractUI {
    private final ListAGVDockController listAGVDockController = new ListAGVDockController();
    private final OrderController orderController = new OrderController();

    @Override
    protected boolean doShow() {
        String status = "REGISTERED";
        List<NewOrder> orderListStatus = orderController.findByStatus(status);
        orderController.listAllOrders(orderListStatus);

        String orderID = Console.readNonEmptyLine("\nChoose the order ID: ", "Order ID required.");
        NewOrder order = orderController.findByID(orderID);

        System.out.println("We'll search the available AGVs ...");
        List<AGVDock> agvDockList = listAGVDockController.AGVByState("free");
        listAGVDockController.listAllAGVs(agvDockList);

        String agvID = Console.readNonEmptyLine("\nChoose the AGV ID to prepare your order: ", "AGV ID required.");
        AGVDock agvDock = listAGVDockController.AGVByID(agvID);

        System.out.println(listAGVDockController.agvPrepareOrder(agvDock, order));

        return true;
    }

    @Override
    public String headline() {
        return "Ask AGV to prepare an Order";
    }


}
