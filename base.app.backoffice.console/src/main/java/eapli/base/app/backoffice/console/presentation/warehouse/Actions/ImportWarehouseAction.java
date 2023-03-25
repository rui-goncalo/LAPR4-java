package eapli.base.app.backoffice.console.presentation.warehouse.Actions;

import eapli.base.app.backoffice.console.presentation.warehouse.ImportWarehouseUI;
import eapli.framework.actions.Action;

public class ImportWarehouseAction implements Action {
    @Override
    public boolean execute() {
        return new ImportWarehouseUI().show();
    }
}