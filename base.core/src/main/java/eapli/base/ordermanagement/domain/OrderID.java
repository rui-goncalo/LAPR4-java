package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.PhoneCustomer;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class OrderID implements ValueObject, Comparable<OrderID> {
    private String orderID;

    protected OrderID() {
    }

    public OrderID(String orderID) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(orderID))) {
            throw new IllegalArgumentException("OrderID should not be null nor empty.");
        }
        this.orderID = orderID;
    }

    public static OrderID valueOf (final String orderID) {
        return new OrderID(orderID);
    }

    @Override
    public int compareTo(OrderID o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "OrderID = " + orderID;
    }
}
