package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

@ApplicationService
public class ListProductService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository prodRepository = PersistenceContext.repositories().products();
    private CategoryDefineController defineControl = new CategoryDefineController();


    public Iterable<Product> allProducts() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        return prodRepository.findAll();
    }

/*    public List<Brand> allProductsByBrand(Brand b) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        return prodRepository.findAllProductsByBrand();
    }*/

    public void printProductsList(List<Product> productList) {
        for (Product p : productList) {
            System.out.println("\n\nCode: " + p.getInternal_code() +
                    "\nName: " + p.getName() +
                    "\nDescription: " + p.getLongDescription().toString() +
                    "\nBrand: " + p.getBrand() +
                    "\nCategory: " + p.getCategory().getName() +
                    "\nPrice: " + p.getPrice() + ".");
        }
    }

    public void printCategoriesList(List<Category> categoryList) {
        for (Category c : categoryList) {
            System.out.println("Code- " + c.getCategoryId());
        }
    }

    public Category findByCategoryCode(Category code) {
        return defineControl.findByCategoryCode(code);
    }
}
