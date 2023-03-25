package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.application.CategoryDefineController;
import eapli.base.productmanagement.domain.Category;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ViewProducts extends AbstractUI {

    private static final CategoryDefineController prodList = new CategoryDefineController();

    public boolean doShow() {
        int optionFilter = 0;

        do {
            switch (optionFilter) {
                case 0:
                    System.out.println("exit");
                    break;

                case 1:
                    List<Category> cat = prodList.findAllCategories();
                    prodList.printCategoryList(cat);
                    String name = Console.readLine("Category: ");
                    prodList.printCategoryList(name);
            }
        } while (optionFilter != 0);

        return false;
    }

    @Override
    public String headline() {
        return "Products";
    }
}
