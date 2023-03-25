package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.application.RegisterCategoryController;
import eapli.base.productmanagement.domain.Category;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterCategoryUI extends AbstractUI {
    private final RegisterCategoryController theController = new RegisterCategoryController();

    @Override
    protected boolean doShow() {
        final Iterable<Category> categories = this.theController.categories();

        final String name = Console.readNonEmptyLine("Insert name of category:", "Name required.");

        try {
            this.theController.registerCategory(Designation.valueOf(name));
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("This category already exists in the database.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register Category";
    }
}
