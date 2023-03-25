package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.app.backoffice.console.presentation.warehouse.Printers.WAislePrinter;
import eapli.base.warehousemanagement.application.ListWAisleController;
import eapli.base.warehousemanagement.domain.WAisle;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListWAisleUI extends AbstractListUI<WAisle> {
    private final ListWAisleController controller = new ListWAisleController();

    @Override
    protected Iterable<WAisle> elements() {
        return controller.allWAisles();
    }

    @Override
    protected Visitor<WAisle> elementPrinter() {
        return new WAislePrinter();
    }

    @Override
    protected String elementName() {
        return "Aisle";
    }

    @Override
    protected String listHeader() {
        return "Version | ID | Accessibility | Begin | End | Depth";
    }

    @Override
    protected String emptyMessage() {
        return "No data was found.";
    }

    @Override
    public String headline() {
        return "List Aisles";
    }
}