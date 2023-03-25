package eapli.base.app.backoffice.console.presentation.warehouse.Actions;

import eapli.base.app.backoffice.console.presentation.warehouse.ListWarehouseUI;
import eapli.framework.actions.Action;

public class ListWarehouseAction implements Action {
    @Override
    public boolean execute() {
        return new ListWarehouseUI().show();
    }
}