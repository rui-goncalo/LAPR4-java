package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListProductUI extends AbstractListUI<Product> {

    private final ListProductController theController = new ListProductController();
    private final ProductPrinter printer = new ProductPrinter();

    @Override
    protected Iterable<Product> elements() {
        return this.theController.allProducts();
    }

    @Override
    protected Visitor<Product> elementPrinter() {
        return printer;
    }

    @Override
    protected String elementName() {
        return "Product";
    }

    @Override
    protected String listHeader() {
        return "Products";
    }

    @Override
    protected String emptyMessage() {
        return "No data\n";
    }

    @Override
    public String headline() {
        return "List Products";
    }
}
