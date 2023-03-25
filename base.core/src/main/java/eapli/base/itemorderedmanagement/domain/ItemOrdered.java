package eapli.base.itemorderedmanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItemOrdered implements AggregateRoot<ItemOrderedID> {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ItemOrderedID itemOrderedID;

    @Column(nullable = false, updatable = false)
    private double itemOrderedPrice;

    private int quantity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products;

//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="order_id")
//    private NewOrder order;

    protected ItemOrdered() {
    }

    public ItemOrdered(ItemOrderedID itemOrderedID, double itemOrderedPrice, int quantity, List<Product> products) {
        this.itemOrderedID = itemOrderedID;
        this.itemOrderedPrice = itemOrderedPrice;
        this.quantity = quantity;
        this.products = products;
    }

    public ItemOrdered(ItemOrderedID itemOrderedID, double itemOrderedPrice, int quantity) {
        this.itemOrderedID = itemOrderedID;
        this.itemOrderedPrice = itemOrderedPrice;
        this.quantity = quantity;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public ItemOrderedID identity() {
        return this.itemOrderedID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getItemOrderedPrice() {
        return itemOrderedPrice;
    }

    @Override
    public String toString() {
        return "ItemOrdered{" +
                "itemOrderedID=" + itemOrderedID +
                ", itemOrderedPrice=" + itemOrderedPrice +
                ", quantity=" + quantity +
                ", products=" + products +
                '}';
    }
}
