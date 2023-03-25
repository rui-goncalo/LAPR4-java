package eapli.base.persistence.impl.inmemory;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.VATCustomer;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCategoryRepository extends InMemoryDomainRepository<Category, String> implements CategoryRepository {
    static {
        InMemoryInitializer.init();
    }

//    @Override
//    public Iterable<Category> findAllCategories(Category category) {
//        return null;
//    }

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

}
