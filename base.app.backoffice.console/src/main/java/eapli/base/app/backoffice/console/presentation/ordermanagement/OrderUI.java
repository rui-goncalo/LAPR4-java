package eapli.base.app.backoffice.console.presentation.ordermanagement;

import eapli.base.customermanagement.application.RegisterCustomerController;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.itemorderedmanagement.domain.ItemOrdered;
import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.*;
import eapli.base.productmanagement.application.CategoryDefineController;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class OrderUI extends AbstractUI {
    private final ListProductController listProductController = new ListProductController();
    private final OrderController orderController = new OrderController();
    private final RegisterCustomerController registerCustomerController = new RegisterCustomerController();
    private final CategoryDefineController categoryDefineController = new CategoryDefineController();
    private final AddUserController addUserController = new AddUserController();

    @Override
    protected boolean doShow() {
        String clerk = Console.readNonEmptyLine("Insert your sales clerk email:", "Email required.");
        OrderClerk orderClerk = orderController.orderClerk(clerk);

        List<ItemOrdered> itemOrderedList = new ArrayList<>();

        Customer customer;
        String pk_str = Console.readLine("Insert the Customer ID: ");

        int pk = Integer.parseInt(pk_str);
        customer = registerCustomerController.findByPK(pk);

        System.out.println("This is the Customer: \n" + customer.toString());

        try {
            System.out.println("\nBelow you'll find the list of products to add to the order.\n");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean flag = true;
        double price = 0.0;

        do {
            List<Product> productList = listProductController.findAllProducts();
            listProductController.listAllProducts(productList);

            List<Product> products = new ArrayList<>();

            String productInternalCode = Console.readNonEmptyLine("\nInsert the product internal code: ", "Internal Code required.");
            Product product = listProductController.findByProductInternalCode(productInternalCode);
            System.out.println(product.toString());

            String quantity_str = Console.readNonEmptyLine("\nInsert the quantity of the previous product:", "Quantity required.");
            int quantity = Integer.parseInt(quantity_str);

            List<Product> list = new ArrayList<>();

            for (int i = 0; i < quantity; i++) {
                list.add(product);
                price += product.getPrice();
            }

            ItemOrdered itemOrdered = orderController.itemOrderedList(list, quantity);
            itemOrderedList.add(itemOrdered);

            String res = Console.readLine("Do you want to add more products? (y/n)");
            if (res.equals("n")) {
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);

        PaymentMethod paymentMethod = orderController.paymentMethod(orderController.showPaymentMethod());
        ShipmentType shipmentType = orderController.shipmentType(orderController.showShipmentType());

        Calendar calendar = Calendar.getInstance();

        Random rand = new Random();
        int random = rand.nextInt(100);
        OrderID orderID = new OrderID(String.valueOf(random));

        OrderPrice orderPrice = orderController.orderPrice(price, shipmentType);

        double total = price + Double.parseDouble(orderPrice.getShipmentCost().toString());

        NewOrder order = orderController.newOrder(orderID, Status.REGISTERED, calendar, orderClerk, customer, paymentMethod, shipmentType, total/*itemOrderedList*/);
        System.out.println(order.toString());

        return true;
    }

    @Override
    public String headline() {
        return "Create a new order";
    }
}
