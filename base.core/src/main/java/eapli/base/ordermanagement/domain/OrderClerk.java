package eapli.base.ordermanagement.domain;

import eapli.base.itemorderedmanagement.domain.ItemOrderedID;
import eapli.base.ordermanagement.application.OrderController;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.infrastructure.authz.domain.model.Role;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class OrderClerk implements ValueObject {
    private String email;
    private Role role;

    protected OrderClerk() {
    }

    public OrderClerk(Role role) {
        this.role = role;
    }

    public OrderClerk(String email, Role role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public static OrderClerk valueOf (final String orderClerk) {
        return new OrderClerk(Role.valueOf(orderClerk));
    }

    public static enum Role {
        SALES_CLERK
    }

    @Override
    public String toString() {
        return "OrderClerk{" +
                "email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
