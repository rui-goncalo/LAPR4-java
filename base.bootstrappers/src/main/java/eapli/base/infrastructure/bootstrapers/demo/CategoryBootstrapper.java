package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoryBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CategoryBootstrapper.class);
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();

    @Override
    public boolean execute() {
        Category category = registerCategory("Technology");
        registerCategory("Food");
        registerCategory("Office");

        return true;
    }

    private Category registerCategory(String name) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        final Category category = new Category(Designation.valueOf(name));

        Category category1;

        try {
            category1 = categoryRepository.save(category);
            assert category1 != null;
            return category1;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", category.identity());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }
}
