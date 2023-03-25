package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.framework.actions.Action;

public class ListProductsAction implements Action {

    @Override
    public boolean execute() {
        return new ListProductUI().show();
    }
}