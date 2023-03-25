package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shipment implements AggregateRoot<Integer> {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ShipmentID shipmentID;

    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    @Embedded
    private ShipmentCost shipmentCost;

    @OneToMany(mappedBy="shipment", cascade = CascadeType.ALL)
    private List<NewOrder> orders = new ArrayList<NewOrder>();

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentID=" + shipmentID +
                ", shipmentType=" + shipmentType +
                ", shipmentCost=" + shipmentCost +
                ", orders=" + orders +
                '}';
    }
}
