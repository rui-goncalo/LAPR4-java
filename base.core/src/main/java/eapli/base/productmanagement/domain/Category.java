package eapli.base.productmanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category implements AggregateRoot<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryId;

    @Embedded
    private Designation name;

    @OneToMany(mappedBy="category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<Product>();

    protected Category() {
    }

    public Category(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Designation name) {
        this.name = name;
    }

    public Category(String categoryId, Designation name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Category that = (Category) o;

        return Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Category)) {
            return false;
        }

        final Category that = (Category) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


    public String getCategoryId() {
        return this.categoryId;
    }

    public Designation getName() {
        return this.name;
    }

    public static Category valueOf(final String category){
        return new Category(category);
    }

    @Override
    public String identity() {
        return this.categoryId;
    }



    @Override
    public String toString() {
        return "Category: " +
                "\nID = " + categoryId +
                "\nName = " + name;
    }
}
