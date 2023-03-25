package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.app.backoffice.console.presentation.warehouse.Printers.AGVDockPrinter;
import eapli.base.warehousemanagement.application.ListAGVDockController;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListAGVDockUI extends AbstractListUI<AGVDock> {
    private final ListAGVDockController controller = new ListAGVDockController();

    @Override
    protected Iterable<AGVDock> elements() {
        return controller.allAGVDocks();
    }

    @Override
    protected Visitor<AGVDock> elementPrinter() {
        return new AGVDockPrinter();
    }

    @Override
    protected String elementName() {
        return "AGVDock";
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
        return "List AGVDocks";
    }
}