package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class ListProductController {

    private final ListProductService listProd = new ListProductService();
    private final ProductRepository prod = PersistenceContext.repositories().products();
    private final CategoryDefineController defineCat = new CategoryDefineController();

    public Iterable<Product> allProducts() {
        return listProd.allProducts();
    }

    public List<Product> findAllProducts() {
        return prod.findAllProducts();
    }

    public void listAllProducts(List<Product> productList) {
        listProd.printProductsList(productList);
    }

    public List<Product> productsByBrand(String brand) {
        Brand b = Brand.valueOf(brand);
        return prod.findAllProductsByBrand(b);
    }

    public Product findByProductInternalCode(String internal_code) {
        return prod.findByProductInternalCode(internal_code);
    }

    public List<Product> productsByCategory(int category) {
        Category c = Category.valueOf(String.valueOf(category));
        return prod.findAllProductsByCategory(c);
    }
}
