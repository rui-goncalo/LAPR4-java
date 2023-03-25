package eapli.base.persistence.impl.jpa;

import eapli.base.productmanagement.domain.Product;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.base.warehousemanagement.repositories.AGVDocksRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaAGVDockRepository extends BaseJpaRepositoryBase<AGVDock, String, String> implements AGVDocksRepository {

    JpaAGVDockRepository() {
        super("id");
    }


    @Override
    public List<AGVDock> findAGVByState(String state) {
        Query q = entityManager().createQuery("SELECT agv FROM AGVDock agv WHERE agv.state = :state");
        q.setParameter("state", state);
        return (q.getResultList());
    }

    @Override
    public AGVDock findAGVByID(String id) {
        TypedQuery<AGVDock> query = entityManager().createQuery("SELECT a FROM AGVDock a WHERE a.id = :id", AGVDock.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


}