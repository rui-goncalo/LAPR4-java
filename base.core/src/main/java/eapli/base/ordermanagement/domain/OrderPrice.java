package eapli.base.ordermanagement.domain;

public class OrderPrice {
    private double price;
    private ShipmentCost shipmentCost;

    protected OrderPrice() {
    }

    public OrderPrice(double price, ShipmentCost shipmentCost) {
        this.price = price;
        this.shipmentCost = shipmentCost;
    }

    public double getPrice() {
        return price;
    }

    public ShipmentCost getShipmentCost() {
        return shipmentCost;
    }

    @Override
    public String toString() {
        return "OrderPrice{" +
                "price=" + price +
                ", shipmentCost=" + shipmentCost +
                '}';
    }
}
