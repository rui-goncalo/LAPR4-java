package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.domain.Status;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaOrderRepository extends JpaAutoTxRepository<NewOrder, OrderID, OrderID> implements OrderRepository {
    public JpaOrderRepository(TransactionalContext autoTx) {
        super(autoTx, "OrderID");
    }

    public JpaOrderRepository(String PUName) {
        super(PUName, Application.settings().getExtendedPersistenceProperties(), "OrderID");
    }


    @Override
    public Iterable<NewOrder> findAllOrders(NewOrder order) {
        return null;
    }

    @Override
    public List<NewOrder> findAllOrders() {
        List<NewOrder> orders = new ArrayList<>();
        TypedQuery<NewOrder> query = super.createQuery("SELECT DISTINCT o FROM NewOrder o", NewOrder.class);
        for (NewOrder o: query.getResultList()) {
            orders.add(o);
        }
        return orders;
    }

    @Override
    public List<NewOrder> findAllOrdersByStatus(Status status) {
        TypedQuery<NewOrder> query = entityManager().createQuery("SELECT o FROM NewOrder o WHERE o.status = :status", NewOrder.class);
        query.setParameter("status", status);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public NewOrder findOrderByID(OrderID orderID) {
        TypedQuery<NewOrder> query = entityManager().createQuery("SELECT o FROM NewOrder o WHERE o.orderID = :orderID", NewOrder.class);
        query.setParameter("orderID", orderID);
        return query.getSingleResult();
    }


}
