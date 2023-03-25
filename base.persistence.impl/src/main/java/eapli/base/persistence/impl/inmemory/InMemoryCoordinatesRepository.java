package eapli.base.persistence.impl.inmemory;

import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.repositories.CoordinatesRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCoordinatesRepository extends InMemoryDomainRepository<Coordinates, Long> implements CoordinatesRepository {

    static {
        InMemoryInitializer.init();
    }
}