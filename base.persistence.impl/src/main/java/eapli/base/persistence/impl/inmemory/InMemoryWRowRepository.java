package eapli.base.persistence.impl.inmemory;

import eapli.base.warehousemanagement.domain.WRow;
import eapli.base.warehousemanagement.repositories.WRowRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWRowRepository extends InMemoryDomainRepository<WRow, Long> implements WRowRepository {

    static {
        InMemoryInitializer.init();
    }
}