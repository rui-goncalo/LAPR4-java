package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.Category;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface CategoryRepository extends DomainRepository<String, Category> {
//    Iterable<Category> findAllCategories(Category category);

    List<Category> findAllCategories();
}
