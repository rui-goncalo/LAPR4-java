package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Money;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShipmentCost implements ValueObject {
    @Column(insertable = false,updatable = false)
    private double shipmentCost;

    protected ShipmentCost() {
    }

    public ShipmentCost(double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    @Override
    public String toString() {
        return "" + shipmentCost;
    }
}
