package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class NewOrder implements AggregateRoot<OrderID> {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private OrderID orderID;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Calendar date;

    @Embedded
    private OrderClerk clerk;

    @OneToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;

    @Enumerated(EnumType.STRING)
    private ShipmentType shipment;

    //    private tax;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public OrderID identity() {
        return this.orderID;
    }

    private double price;

    protected NewOrder() {
    }

    public NewOrder(OrderID orderID, Status status, Calendar date, OrderClerk clerk, Customer customer, PaymentMethod payment_method, ShipmentType shipment, double price) {
        this.orderID = orderID;
        this.status = status;
        this.date = date;
        this.clerk = clerk;
        this.customer = customer;
        this.payment_method = payment_method;
        this.shipment = shipment;
        this.price = price;
    }

    public NewOrder(Status status, Calendar date, OrderClerk clerk, Customer customer, PaymentMethod payment_method, ShipmentType shipment, double price) {
        this.status = status;
        this.date = date;
        this.clerk = clerk;
        this.customer = customer;
        this.payment_method = payment_method;
        this.shipment = shipment;
        this.price = price;
    }

    public OrderID getOrderID() {
        return orderID;
    }

    public Status getStatus() {
        return status;
    }

    public Calendar getDate() {
        return date;
    }

    public OrderClerk getClerk() {
        return clerk;
    }

    public Customer getCustomer() {
        return customer;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public ShipmentType getShipment() {
        return shipment;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order: " +
                "\nOrder ID = " + orderID +
                "\nStatus = " + status +
                "\nDate = " + date +
                "\nClerk = " + clerk +
                "\nCustomer = " + customer +
                "\nPayment Method = " + payment_method +
                "\nShipment = " + shipment;
    }
}