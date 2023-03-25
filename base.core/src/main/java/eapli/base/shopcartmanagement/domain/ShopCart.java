package eapli.base.shopcartmanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShopCart implements AggregateRoot<ShopCartID> {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ShopCartID shopCartID;

    @OneToMany(mappedBy="shopCart", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @OneToOne
    private Customer customer;

    protected ShopCart() {
    }

    public ShopCart(ShopCartID shopCartID) {
        this.shopCartID = shopCartID;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public ShopCartID identity() {
        return this.shopCartID;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "shopCartID=" + shopCartID +
                ", items=" + items +
                ", customer=" + customer +
                '}';
    }
}
