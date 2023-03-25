package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

public enum Status implements ValueObject {
    REGISTERED,
    BEING_PREPARED,
    READY_FOR_PACKAGING,
    PAYMENT_PENDING,
    PAID,
    ALREADY_BEEN_PREPARED_BY_THE_AGV,
    DISPATCHED_FOR_CUSTOMER_DELIVERY,
    BEING_DELIVERED,
    DELIVERED_BY_CARRIER,
    DELIVERED
}
