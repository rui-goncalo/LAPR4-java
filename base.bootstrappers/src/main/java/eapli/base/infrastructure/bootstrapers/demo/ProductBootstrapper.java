package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(ProductBootstrapper.class);
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    @Override
    public boolean execute() {
        Product product = registerProduct("iPhone", "Smartphone", "Smartphone with an Apple as a logo", 1, "Apple", "12345abcde", 12345, 1279.00, 123, 150.0);
        registerProduct("Pizza Pepperoni", "Pizza P", "Pizza com Pepperoni fatiado", 2, "Ristorante", "67890fghij", 67890, 3.29, 456, 337.0);
        registerProduct("Cadeira Executiva", "Cadeira", "Cadeira de Escritório Executiva", 3, "VINSETTO", "13245abcde", 13245, 96.99, 789, 1000.0);

        return true;
    }

    private Product registerProduct(String name, String short_description, String long_description, int category,
                                    String brand, String reference, int barcode, double price, int internal_code, double weight) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        final Product product = new Product(name, short_description, long_description, Category.valueOf(String.valueOf(category)),
                 Brand.valueOf(brand), reference, barcode, price, internal_code, weight);

        Product product1;

        try {
            product1 = productRepository.save(product);
            assert product1 != null;
            return product1;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", product.identity());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }
}
