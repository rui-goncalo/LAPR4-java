package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class ShipmentID implements ValueObject, Comparable<ShipmentID> {
    private String shippmentID;

    protected ShipmentID() {
    }

    public ShipmentID(String shippmentID) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(shippmentID))) {
            throw new IllegalArgumentException("ShippmentID should not be null nor empty.");
        }
        this.shippmentID = shippmentID;
    }

    public static ShipmentID valueOf (final String shippmentID) {
        return new ShipmentID(shippmentID);
    }

    @Override
    public int compareTo(ShipmentID o) {
        return 0;
    }

    @Override
    public String toString() {
        return "ShippmentID{" +
                "shippmentID='" + shippmentID + '\'' +
                '}';
    }
}
