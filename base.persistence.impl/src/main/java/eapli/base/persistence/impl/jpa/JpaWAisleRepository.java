package eapli.base.persistence.impl.jpa;

import eapli.base.warehousemanagement.domain.WAisle;
import eapli.base.warehousemanagement.repositories.WAisleRepository;

public class JpaWAisleRepository extends BaseJpaRepositoryBase<WAisle, Long, Long> implements WAisleRepository {

    JpaWAisleRepository() {
        super("id");
    }
}