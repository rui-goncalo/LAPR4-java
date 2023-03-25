package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.app.backoffice.console.presentation.warehouse.Printers.WRowPrinter;
import eapli.base.warehousemanagement.application.ListWRowController;
import eapli.base.warehousemanagement.domain.WRow;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListWRowUI extends AbstractListUI<WRow> {
    private final ListWRowController controller = new ListWRowController();

    @Override
    protected Iterable<WRow> elements() {
        return controller.allWRows();
    }

    @Override
    protected Visitor<WRow> elementPrinter() {
        return new WRowPrinter();
    }

    @Override
    protected String elementName() {
        return "Row";
    }

    @Override
    protected String listHeader() {
        return "Version | ID | Shelves | Begin | End";
    }

    @Override
    protected String emptyMessage() {
        return "No data was found.";
    }

    @Override
    public String headline() {
        return "List Rows";
    }
}