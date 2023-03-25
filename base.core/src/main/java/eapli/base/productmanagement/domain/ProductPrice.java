package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Money;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductPrice implements ValueObject, Comparable<ProductPrice> {
    @Column(insertable = false,updatable = false)
    private double price;

    protected ProductPrice() {
    }

    public ProductPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price=" + price +
                '}';
    }

    public static ProductPrice valueOf(double price) throws IllegalAccessException {
        return new ProductPrice(price);
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(ProductPrice o) {
        return 0;
    }
}
