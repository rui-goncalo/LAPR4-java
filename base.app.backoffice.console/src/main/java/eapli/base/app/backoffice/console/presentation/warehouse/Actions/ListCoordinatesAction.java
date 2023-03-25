package eapli.base.app.backoffice.console.presentation.warehouse.Actions;

import eapli.base.app.backoffice.console.presentation.warehouse.ListCoordinatesUI;
import eapli.framework.actions.Action;

public class ListCoordinatesAction implements Action {
    @Override
    public boolean execute() {
        return new ListCoordinatesUI().show();
    }
}