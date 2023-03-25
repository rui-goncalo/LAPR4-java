package eapli.base.persistence.impl.jpa;

import eapli.base.warehousemanagement.domain.Warehouse;
import eapli.base.warehousemanagement.repositories.WarehouseRepository;

public class JpaWarehouseRepository extends BaseJpaRepositoryBase<Warehouse, Long, Long> implements WarehouseRepository {

    JpaWarehouseRepository() {
        super("id");
    }
}