package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListProductByBrandUI extends AbstractListUI<Product> {

    private final ListProductController theController = new ListProductController();
    private final ProductPrinter printer = new ProductPrinter();
    private String brand;

    @Override
    protected Iterable<Product> elements() {
        return this.theController.productsByBrand(brand);
    }

    @Override
    protected Visitor<Product> elementPrinter() {
        return printer;
    }

    @Override
    protected String elementName() {
        return "Brand";
    }

    @Override
    protected String listHeader() {
        return "Products by Brand";
    }

    @Override
    protected String emptyMessage() {
        return "No data\n";
    }

    @Override
    public String headline() {
        return "List Products";
    }

    @Override
    protected boolean doShow() {
        brand = Console.readLine("Please insert your brand: ");

        return super.doShow();
    }
}