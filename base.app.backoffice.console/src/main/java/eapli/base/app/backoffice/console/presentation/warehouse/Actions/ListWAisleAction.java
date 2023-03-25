package eapli.base.app.backoffice.console.presentation.warehouse.Actions;

import eapli.base.app.backoffice.console.presentation.warehouse.ListWAisleUI;
import eapli.framework.actions.Action;

public class ListWAisleAction implements Action {
    @Override
    public boolean execute() {
        return new ListWAisleUI().show();
    }
}