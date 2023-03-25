package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.itemorderedmanagement.domain.ItemOrdered;
import eapli.base.itemorderedmanagement.domain.ItemOrderedID;
import eapli.base.ordermanagement.domain.*;
import eapli.base.itemorderedmanagement.repositories.ItemOrderedRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;
import java.util.List;

@UseCaseController
public class OrderController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final OrderService orderService = new OrderService();
    private final ItemOrderedRepository itemOrderedRepository = PersistenceContext.repositories().itemsOrdered();
    private final ListProductController listProductController = new ListProductController();

    public NewOrder newOrder(OrderID orderID, Status status, Calendar date, OrderClerk clerk, Customer customer,
                             PaymentMethod payment_method, ShipmentType shipment, double price/*List<ItemOrdered> itemOrdereds*/) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        final var order = new NewOrder(orderID, Status.REGISTERED, date, clerk, customer, payment_method, shipment, price/*, itemOrdereds*/);

        return orderRepository.save(order);
    }

    public ItemOrdered itemOrderedList (List<Product> products, int quantity) {

        Long productID = listProductController.findByProductInternalCode(String.valueOf(products.iterator().next().getInternal_code())).getId();
        ItemOrderedID id = new ItemOrderedID(String.valueOf(productID));
        double productPrice = listProductController.findByProductInternalCode(String.valueOf(products.iterator().next().getInternal_code())).getPrice();

        double final_price = productPrice * quantity;

        ItemOrdered itemOrdered = new ItemOrdered(id, final_price, quantity, products);

        return this.itemOrderedRepository.save(itemOrdered);
    }

    public OrderPrice orderPrice(double price, ShipmentType shipmentType) {
        double fee = Double.parseDouble(orderService.shipmentCostMethod(shipmentType).toString());

        ShipmentCost shipmentCost = new ShipmentCost(fee);
        return new OrderPrice(price, shipmentCost);
    }

    public OrderClerk orderClerk(String email) {
        return new OrderClerk(email, OrderClerk.Role.SALES_CLERK);
    }

    public PaymentMethod paymentMethod(int option) {
        return orderService.paymentMethod(option);
    }

    public ShipmentType shipmentType(int option) {
        return orderService.shipmentType(option);
    }

    public int showPaymentMethod() {
        return orderService.showPaymentMethods();
    }

    public int showShipmentType() {
        return orderService.showShipmentMethods();
    }

    public List<NewOrder> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    public void listAllOrders(List<NewOrder> orderList) {
        orderService.printListOrders(orderList);
    }

    public List<NewOrder> findByStatus(String s) {
        Status status = Status.valueOf(s);
        return orderRepository.findAllOrdersByStatus(status);
    }

    public NewOrder findByID(String id) {
        OrderID orderID = OrderID.valueOf(id);
        return orderRepository.findOrderByID(orderID);
    }

    public NewOrder updateOrder(NewOrder newOrder, String status) {
        newOrder.setStatus(Status.valueOf(status));
        orderRepository.save(newOrder);

        return newOrder;
    }
}
