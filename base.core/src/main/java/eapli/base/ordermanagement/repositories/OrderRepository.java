package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.domain.Status;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface OrderRepository extends DomainRepository<OrderID, NewOrder> {
    Iterable<NewOrder> findAllOrders(NewOrder order);

    public List<NewOrder> findAllOrders();

    List<NewOrder> findAllOrdersByStatus(Status status);

    NewOrder findOrderByID(OrderID orderID);
}
