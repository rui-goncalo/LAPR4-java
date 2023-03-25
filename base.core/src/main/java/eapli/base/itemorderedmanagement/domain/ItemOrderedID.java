package eapli.base.itemorderedmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ItemOrderedID implements ValueObject, Comparable<ItemOrderedID> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String itemOrderedID;

    protected ItemOrderedID() {
    }

    public ItemOrderedID(String itemOrderedID) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(itemOrderedID))) {
            throw new IllegalArgumentException("ItemOrderedID should not be null nor empty.");
        }
        this.itemOrderedID = itemOrderedID;
    }

    public static ItemOrderedID valueOf (final String itemOrderedID) {
        return new ItemOrderedID(itemOrderedID);
    }

    @Override
    public int compareTo(ItemOrderedID o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "ItemOrderedID{" +
                "itemOrderedID='" + itemOrderedID + '\'' +
                '}';
    }
}
