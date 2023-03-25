package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.framework.actions.Action;

import javax.swing.*;

public class ListProductByCategoryAction implements Action {

    @Override
    public boolean execute() {
        return new ListProductByCategoryUI().show();
    }
}
