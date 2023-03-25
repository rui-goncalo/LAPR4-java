package eapli.base.warehousemanagement.repositories;

import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface AGVDocksRepository extends DomainRepository<String, AGVDock> {
    List<AGVDock> findAGVByState(String state);

    AGVDock findAGVByID(String id);
}