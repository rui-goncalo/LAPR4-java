package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListProductByCategoryUI extends AbstractListUI<Product> {

    private final ListProductController theController = new ListProductController();
    private final ProductPrinter printer = new ProductPrinter();
    private int category;

    @Override
    protected Iterable<Product> elements() {
        return this.theController.productsByCategory(category);
    }

    @Override
    protected Visitor<Product> elementPrinter() {
        return printer;
    }

    @Override
    protected String elementName() {
        return "Category";
    }

    @Override
    protected String listHeader() {
        return "Products by Category";
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
        category = Console.readInteger("Please insert your Category: ");
        return super.doShow();
    }
}
