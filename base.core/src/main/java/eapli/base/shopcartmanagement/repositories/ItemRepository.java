package eapli.base.shopcartmanagement.repositories;

import eapli.base.shopcartmanagement.domain.Item;
import eapli.base.shopcartmanagement.domain.ItemID;
import eapli.base.shopcartmanagement.domain.ShopCart;
import eapli.base.shopcartmanagement.domain.ShopCartID;
import eapli.framework.domain.repositories.DomainRepository;

public interface ItemRepository extends DomainRepository<ItemID, Item> {
    Iterable<Item> findAllItems(Item item);

}
