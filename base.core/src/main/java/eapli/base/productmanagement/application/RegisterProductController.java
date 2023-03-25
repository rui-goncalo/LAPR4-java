package eapli.base.productmanagement.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class RegisterProductController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();

    public Product registerProduct(final String name, final String short_description, final String long_description,
                                   final String category, final String brand, final String reference,
                                   final int barcode, final double price, int internal_code, double weight, final InputStream image) throws IOException {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        //Category cat = categoryRepository.findByName(category);
        Category cat = Category.valueOf(category);

        final var newProduct = new Product(name, short_description, long_description, cat, Brand.valueOf(brand), reference, barcode, price,
                internal_code, weight, IOUtils.toByteArray(image));
        return productRepository.save(newProduct);
    }

    public Product registerProduct(final String name, final String short_description, final String long_description,
                                   final String category, final String brand, final String reference,
                                   final int barcode, final double price, int internal_code, double weight) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        final var newProduct = new Product(name, short_description, long_description, Category.valueOf(category), Brand.valueOf(brand), reference, barcode, price, internal_code, weight);
        return productRepository.save(newProduct);
    }

    public Iterable<Product> products() {
        return null;
    }
}