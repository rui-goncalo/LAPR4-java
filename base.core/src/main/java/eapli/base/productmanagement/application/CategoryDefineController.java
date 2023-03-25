package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.List;

public class CategoryDefineController {

    private static final ListProductService listProd = new ListProductService();
    private final ProductRepository prod = PersistenceContext.repositories().products();

    public static Category findByCategoryCode(Category code) {
        return listProd.findByCategoryCode(code);
    }

    public List<Category> findAllCategories() {
        return prod.findAllCategories();
    }

    public void printCategoryList(List<Category> categories) {
        listProd.printCategoriesList(categories);
    }

    public void printProductList(List<Product> prod) {
        listProd.printProductsList(prod);
    }

    public List<Product> getProductByCategory(Category category) {
        return prod.findAllProductsByCategory(category);
    }

    public void printCategoryList(String id) {
        Category categories = new Category(id);
        Category categoryProd = CategoryDefineController.findByCategoryCode(categories);
        List<Product> productCategory = getProductByCategory(categoryProd);
        printProductList(productCategory);
    }
}
