package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.warehousemanagement.application.ImportWarehouseController;
import eapli.framework.presentation.console.AbstractUI;

public class ImportWarehouseUI extends AbstractUI {
    private final ImportWarehouseController theController = new ImportWarehouseController();

    @Override
    protected boolean doShow() {
        this.theController.importWarehouse();

        return false;
    }

    @Override
    public String headline() {
        return "Importing JSON file...";
    }
}