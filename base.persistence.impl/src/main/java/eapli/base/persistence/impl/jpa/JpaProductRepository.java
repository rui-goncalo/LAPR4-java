package eapli.base.persistence.impl.jpa;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.io.util.Console;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaProductRepository extends BaseJpaRepositoryBase<Product, Long, Long> implements ProductRepository {

    JpaProductRepository() {
        super("id");
    }

    @Override
    public List<Product> findAllProductsByBrand(Brand brand) {

        //Brand input = Brand.valueOf(Console.readLine("Insert Brand: "));

        TypedQuery<Product> query = entityManager().createQuery("SELECT p FROM Product p WHERE p.brand = :brand", Product.class);
        query.setParameter("brand", brand);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public List<Product> findAllProductsByCategory(Category category) {
        TypedQuery<Product> query = entityManager().createQuery("SELECT p FROM Product p WHERE p.category = :category", Product.class);
        query.setParameter("category", category);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        TypedQuery<Product> query = super.createQuery("SELECT DISTINCT p FROM Product p", Product.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public Product findByProductInternalCode(String internal_code) {
        Query q = entityManager().createQuery("SELECT p FROM Product p " + " WHERE p.internal_code = :internal_code");
        q.setParameter("internal_code", Integer.parseInt(internal_code));
        return (Product) q.getSingleResult();
    }

    @Override
    public Optional<Product> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {
    }
}
