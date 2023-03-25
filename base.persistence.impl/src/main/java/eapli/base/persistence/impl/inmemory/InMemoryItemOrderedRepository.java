package eapli.base.persistence.impl.inmemory;

import eapli.base.itemorderedmanagement.domain.ItemOrdered;
import eapli.base.itemorderedmanagement.domain.ItemOrderedID;
import eapli.base.itemorderedmanagement.repositories.ItemOrderedRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryItemOrderedRepository extends InMemoryDomainRepository<ItemOrdered, ItemOrderedID> implements ItemOrderedRepository {
    static {
        InMemoryInitializer.init();
    }
//
//    @Override
//    public Iterable<ItemOrdered> findAllItemsOrdered(ItemOrdered ItemOrdered) {
//        return null;
//    }
}
