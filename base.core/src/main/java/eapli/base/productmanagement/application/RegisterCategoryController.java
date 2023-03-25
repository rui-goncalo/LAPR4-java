package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class RegisterCategoryController {
    //Tem que ser um Sales Clerk
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();

    public Category registerCategory(final Designation name) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        final var category = new Category(name);

        System.out.printf("The following category was created: " + category.toString() + "\n");

        return categoryRepository.save(category);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Iterable<Category> categories() {
        return null;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }

}
