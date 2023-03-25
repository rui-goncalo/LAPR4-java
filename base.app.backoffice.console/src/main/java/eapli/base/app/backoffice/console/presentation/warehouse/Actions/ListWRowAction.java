package eapli.base.app.backoffice.console.presentation.warehouse.Actions;

import eapli.base.app.backoffice.console.presentation.warehouse.ListWRowUI;
import eapli.framework.actions.Action;

public class ListWRowAction implements Action {
    @Override
    public boolean execute() {
        return new ListWRowUI().show();
    }
}