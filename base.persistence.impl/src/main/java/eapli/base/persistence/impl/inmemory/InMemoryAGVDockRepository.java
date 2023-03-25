package eapli.base.persistence.impl.inmemory;

import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.base.warehousemanagement.repositories.AGVDocksRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryAGVDockRepository extends InMemoryDomainRepository<AGVDock, String> implements AGVDocksRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<AGVDock> findAGVByState(String state) {
        return findAGVByState(state);
    }

    @Override
    public AGVDock findAGVByID(String id) {
        return findAGVByID(id);
    }


}