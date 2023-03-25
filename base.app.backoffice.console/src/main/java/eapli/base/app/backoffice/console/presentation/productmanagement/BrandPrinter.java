package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class BrandPrinter implements Visitor<Brand> {

    @Override
    public void visit(Brand visitee) {
        System.out.printf("Name: %s", visitee.getBrandName());
    }
}
