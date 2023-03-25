package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.domain.Category;
import eapli.framework.visitor.Visitor;

public class CategoryPrinter implements Visitor<Category> {

    @Override
    public void  visit(Category category) {
        System.out.printf("ID: %s", category.getCategoryId() + " " + "Description ", category.getName());
    }
}