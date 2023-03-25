package eapli.base.persistence.impl.inmemory;

import eapli.base.warehousemanagement.domain.WAisle;
import eapli.base.warehousemanagement.repositories.WAisleRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWAisleRepository extends InMemoryDomainRepository<WAisle, Long> implements WAisleRepository {

    static {
        InMemoryInitializer.init();
    }
}