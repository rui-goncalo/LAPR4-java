package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.domain.Status;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryOrderRepository extends InMemoryDomainRepository<NewOrder, OrderID> implements OrderRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public Iterable<NewOrder> findAllOrders(NewOrder order) {
        return null;
    }

    @Override
    public List<NewOrder> findAllOrders() {
        return findAllOrders();
    }

    @Override
    public List<NewOrder> findAllOrdersByStatus(Status status) {
        return findAllOrdersByStatus(status);
    }

    @Override
    public NewOrder findOrderByID(OrderID orderID) {
        return findOrderByID(orderID);
    }


}
