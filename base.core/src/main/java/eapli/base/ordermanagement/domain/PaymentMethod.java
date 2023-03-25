package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

public enum PaymentMethod implements ValueObject {
    PAYPAL,
    APPLE_PAY,
    CREDIT_CARD,
    BANK_TRANSFER
}
