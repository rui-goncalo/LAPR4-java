package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ProductRepository extends DomainRepository<Long, Product> {

    List<Product> findAllProductsByBrand(Brand brand);

    List<Product> findAllProductsByCategory(Category category);

    List<Category> findAllCategories();

    List<Product> findAllProducts();

    Product findByProductInternalCode(String code);
}
