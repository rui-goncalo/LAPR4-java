package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class ProductPrinter implements Visitor<Product> {
    @Override
    public void visit(Product visitee) {
        System.out.printf("Name: %s | Short Description: %s | Long Description %s | Brand: %s | Reference: %s | BarCode: %d | Price: %.2f | Internal Code: %d | Weight: %.2f\n ",
                visitee.getName(),
                visitee.getShortDescription(),
                visitee.getLongDescription(),
                visitee.getBrand().toString(),
                visitee.getReference(),
                visitee.getBarcode(),
                visitee.getPrice(),
                visitee.getInternal_code(),
                visitee.getWeight());
    }
}

