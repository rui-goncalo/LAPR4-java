package eapli.base.itemorderedmanagement.repositories;

import eapli.base.itemorderedmanagement.domain.ItemOrdered;
import eapli.base.itemorderedmanagement.domain.ItemOrderedID;
import eapli.framework.domain.repositories.DomainRepository;

public interface ItemOrderedRepository extends DomainRepository<ItemOrderedID, ItemOrdered> {
//    Iterable<ItemOrdered> findAllItemsOrdered(ItemOrdered ItemOrdered);
}
