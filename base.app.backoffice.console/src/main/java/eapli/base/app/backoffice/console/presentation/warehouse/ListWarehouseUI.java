package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.app.backoffice.console.presentation.warehouse.Printers.WarehousePrinter;
import eapli.base.warehousemanagement.application.ListWarehouseController;
import eapli.base.warehousemanagement.domain.Warehouse;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListWarehouseUI extends AbstractListUI<Warehouse> {
    private final ListWarehouseController controller = new ListWarehouseController();

    @Override
    protected Iterable<Warehouse> elements() {
        return controller.allWarehouses();
    }

    @Override
    protected Visitor<Warehouse> elementPrinter() {
        return new WarehousePrinter();
    }

    @Override
    protected String elementName() {
        return "Warehouse";
    }

    @Override
    protected String listHeader() {
        return "Version | ID | Name | Length | Width | Square | Unit";
    }

    @Override
    protected String emptyMessage() {
        return "No data was found.";
    }

    @Override
    public String headline() {
        return "List Warehouses";
    }
}