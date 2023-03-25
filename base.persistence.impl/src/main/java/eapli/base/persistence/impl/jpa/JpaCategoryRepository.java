package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaCategoryRepository extends JpaAutoTxRepository<Category, String, String> implements CategoryRepository {
    public JpaCategoryRepository(TransactionalContext autoTx) {
        super(autoTx, "categoryId");
    }

    public JpaCategoryRepository(String PUName) {
        super(PUName, Application.settings().getExtendedPersistenceProperties(), "categoryId");
    }

//    @Override
//    public Iterable<Category> findAllCategories(Category category) {
//        return null;
//    }

//    @Override
//    public List<Category> findAllCategories() {
//        return findAllCategories();
//    }

    @Override
    public List<Category> findAllCategories() {
        TypedQuery<Category> query = super.createQuery("SELECT DISTINCT c FROM Category c", Category.class);
        return new ArrayList<>(query.getResultList());
    }

}
