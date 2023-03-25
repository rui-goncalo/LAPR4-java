package eapli.base.shopcartmanagement.domain;

import eapli.base.customermanagement.domain.NameCustomer;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ShopCartID implements ValueObject, Comparable<ShopCartID> {
    private String shopCartID;

    protected ShopCartID() {
    }

    public ShopCartID(String shopCartID) {
        this.shopCartID = shopCartID;
    }

    public static ShopCartID valueOf (final String shopCartID) {
        return new ShopCartID(shopCartID);
    }

    @Override
    public int compareTo(final ShopCartID o) {
        return shopCartID.compareTo(o.shopCartID);
    }

    @Override
    public String toString() {
        return "ShopCartID{" +
                "shopCartID='" + shopCartID + '\'' +
                '}';
    }
}
