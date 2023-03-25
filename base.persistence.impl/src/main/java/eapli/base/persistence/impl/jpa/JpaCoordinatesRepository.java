package eapli.base.persistence.impl.jpa;

import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.repositories.CoordinatesRepository;

public class JpaCoordinatesRepository extends BaseJpaRepositoryBase<Coordinates, Long, Long> implements CoordinatesRepository {

    JpaCoordinatesRepository() {
        super("id");
    }
}