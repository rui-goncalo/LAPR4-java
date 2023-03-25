package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.itemorderedmanagement.domain.ItemOrdered;
import eapli.base.itemorderedmanagement.domain.ItemOrderedID;
import eapli.base.itemorderedmanagement.repositories.ItemOrderedRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaItemOrderedRepository extends JpaAutoTxRepository<ItemOrdered, ItemOrderedID, ItemOrderedID> implements ItemOrderedRepository {
    public JpaItemOrderedRepository(TransactionalContext autoTx) {
        super(autoTx, "itemOrderedID");
    }

    public JpaItemOrderedRepository(String PUName) {
        super(PUName, Application.settings().getExtendedPersistenceProperties(), "itemOrderedID");
    }

//    @Override
//    public Iterable<ItemOrdered> findAllItemsOrdered(ItemOrdered ItemOrdered) {
//        return null;
//    }

    
}
