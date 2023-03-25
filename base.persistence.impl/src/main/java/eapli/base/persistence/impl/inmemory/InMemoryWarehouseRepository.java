package eapli.base.persistence.impl.inmemory;

import eapli.base.warehousemanagement.domain.Warehouse;
import eapli.base.warehousemanagement.repositories.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse, Long> implements WarehouseRepository {

    static {
        InMemoryInitializer.init();
    }
}