package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.app.backoffice.console.presentation.warehouse.Printers.CoordinatesPrinter;
import eapli.base.warehousemanagement.application.ListCoordinatesController;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListCoordinatesUI extends AbstractListUI<Coordinates> {
    private final ListCoordinatesController controller = new ListCoordinatesController();

    @Override
    protected Iterable<Coordinates> elements() {
        return controller.allCoordinates();
    }

    @Override
    protected Visitor<Coordinates> elementPrinter() {
        return new CoordinatesPrinter();
    }

    @Override
    protected String elementName() {
        return "Coordinates";
    }

    @Override
    protected String listHeader() {
        return "Version | ID | lSquare | wSquare";
    }

    @Override
    protected String emptyMessage() {
        return "No data was found.";
    }

    @Override
    public String headline() {
        return "List Coordinates";
    }
}