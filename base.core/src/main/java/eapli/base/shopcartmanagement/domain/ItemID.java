package eapli.base.shopcartmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemID implements ValueObject, Comparable<ItemID> {
    private int itemID;

    protected ItemID() {
    }

    public ItemID(final int itemID) {
        this.itemID = itemID;
    }

    public static ItemID valueOf(final int itemID) {
        return new ItemID(itemID);
    }

    @Override
    public int compareTo(ItemID o) {
        return 0;
    }

    @Override
    public String toString() {
        return "ItemID{" +
                "itemID='" + itemID + '\'' +
                '}';
    }
}
