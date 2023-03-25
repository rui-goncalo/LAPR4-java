package eapli.base.shopcartmanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;

import javax.persistence.*;

@Entity
public class Item implements AggregateRoot<ItemID> {
    @EmbeddedId
    private ItemID itemID;

    @Column(insertable = false, updatable = false)
    private double itemPrice;

    private int itemQuantity;

    @OneToOne
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="shopcart_id")
    private ShopCart shopCart;

    public ShopCart getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShopCart shopCart) {
        this.shopCart = shopCart;
    }

    protected Item() {
    }

    public Item(ItemID itemID, double itemPrice, int itemQuantity, Product product) {
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.product = product;
    }

    public Item(double itemPrice, int itemQuantity, Product product) {
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.product = product;
    }


    //CHECK THIS
    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public ItemID identity() {
        return this.itemID;
    }

    public ItemID getItemID() {
        return itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                ", product=" + product +
                ", shopCart=" + shopCart +
                '}';
    }
}
