
package eapli.base.persistence.impl.inmemory;

import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, Long> implements ProductRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<Product> findAllProductsByBrand(Brand brand) {
        Map<Long, Product> d = data();
        List<Product> prods = new ArrayList<>();
        for(Product prod: d.values()){
            if (prod.getBrand().equals(brand))
                prods.add(prod);
        }

        return prods;
    }

    //TODO: basear-me no find all products by brand
    @Override
    public List<Product> findAllProductsByCategory(Category category) {
        return null;
    }

    @Override
    public Product findByProductInternalCode(String internal_code) {
        return findByProductInternalCode(internal_code);
    }

    @Override
    public List<Category> findAllCategories() {
        Set<Category> categories = new HashSet<>();
        for(Product prod: data().values()){
            categories.add(prod.getCategory());
        }
        return new ArrayList<>(categories);
    }

    @Override
    public List<Product> findAllProducts() {
        return findAllProducts();
    }
}
