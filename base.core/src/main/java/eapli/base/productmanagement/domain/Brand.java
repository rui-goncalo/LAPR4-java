package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;



public class Brand implements ValueObject, Comparable<Brand> {

    private String brandName;

    protected Brand() {
    }

    public Brand(String brandName) throws IllegalArgumentException {
        if(StringPredicates.isNullOrEmpty(brandName)) {
            throw new IllegalArgumentException("The brand name cannot be null or empty");
        }

        if(brandName.length() > 50) {
            throw new IllegalArgumentException("The brand name should not have more than 50 charac.");
        }

        this.brandName = brandName;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public static Brand valueOf(final String brandName){
        return new Brand(brandName);
    }

    @Override
    public String toString() {
        return brandName;
    }

    @Override
    public int compareTo(Brand o) {
        return 0;
    }
}
