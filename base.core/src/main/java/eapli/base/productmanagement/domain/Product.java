package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;


import javax.persistence.*;
import java.util.Arrays;


@Entity
public class Product implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String short_description;
    private String long_description;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    @Embedded
    @Column(nullable = false)
    private Brand brand;
    @Column(nullable = false)
    private String reference;
    private int barcode;
    private double price;
    @Column(unique = true, nullable = false)
    private int internal_code;
    private double weight;
    @Lob
    private byte[] image;

    public Product(String name, String short_description, String long_description, Category category, Brand brand, String reference,
                   int barcode, double price, int internal_code, double weight, byte[] image) {
        this(name, short_description, long_description, category, brand, reference, barcode, price, internal_code, weight);
        Preconditions.nonNull(image);

        changeImage(image);
    }

    public Product(String name, String short_description, String long_description, Category category, Brand brand, String reference,
                   int barcode, double price, int internal_code, double weight) {
        //Preconditions.ensure(descriptionMeetsMinimumRequirements(short_description));
        //Preconditions.ensure(descriptionMeetsMinimumRequirements(long_description));


        this.name = name;
        this.short_description = short_description;
        this.long_description = long_description;
        this.category = category;
        this.brand = brand;
        this.reference = reference;
        this.barcode = barcode;
        this.price = price;
        this.internal_code = internal_code;
        this.weight = weight;
        //this.warehouse = warehouse;
    }

    protected Product() {
    }

    public void changeImage(final byte[] image) {
        // defensive copy
        this.image = Arrays.copyOf(image, image.length);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Product)) {
            return false;
        }

        final Product that = (Product) other;
        if (this == that) {
            return true;
        }

        return identity().equals(
                that.identity()) &&
                name.equals(this.name) &&
                short_description.equals(this.short_description) &&
                long_description.equals(this.long_description) &&
                category.equals(this.category) &&
                brand.equals(this.brand) &&
                reference.equals(this.reference) &&
                barcode == this.barcode &&
                price == this.price &&
                internal_code == this.internal_code &&
                weight == this.weight &&
                image.equals(this.image); //&&
        //warehouse.equals(this.warehouse)
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        if (this.short_description.isEmpty()) {
            return "This field is mandatory";
        }
        return short_description;
    }

    public String getLongDescription() {
        return long_description;
    }

    public Brand getBrand() {
        return brand;
    }


    public String getShort_description() {
        return short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public Category getCategory() {
        return category;
    }

    public String getReference() {
        return reference;
    }

    public int getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public int getInternal_code() {
        return internal_code;
    }

    public double getWeight() {
        return weight;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product: " +
                "\nid = " + id +
                "\nname= " + name +
                "\nshort_description = " + short_description +
                "\nlong_description = " + long_description +
                "\ncategory = " + category.getName() +
                "\nbrand = " + brand +
                "\nreference = " + reference +
                "\nbarcode = " + barcode +
                "\nprice = " + price +
                "\ninternal_code = " + internal_code +
                "\nweight = " + weight +
                "\nimage = " + Arrays.toString(image);
    }
}