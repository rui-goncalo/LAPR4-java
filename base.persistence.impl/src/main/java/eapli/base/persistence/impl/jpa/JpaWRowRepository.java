package eapli.base.persistence.impl.jpa;

import eapli.base.warehousemanagement.domain.WRow;
import eapli.base.warehousemanagement.repositories.WRowRepository;

public class JpaWRowRepository extends BaseJpaRepositoryBase<WRow, Long, Long> implements WRowRepository {

    JpaWRowRepository() {
        super("id");
    }
}