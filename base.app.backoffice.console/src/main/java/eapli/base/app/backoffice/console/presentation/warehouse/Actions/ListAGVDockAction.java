package eapli.base.app.backoffice.console.presentation.warehouse.Actions;

import eapli.base.app.backoffice.console.presentation.warehouse.ListAGVDockUI;
import eapli.framework.actions.Action;

public class ListAGVDockAction implements Action {
    @Override
    public boolean execute() {
        return new ListAGVDockUI().show();
    }
}