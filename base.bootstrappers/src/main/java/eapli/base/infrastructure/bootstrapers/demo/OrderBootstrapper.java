package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.framework.actions.Action;

import java.util.Calendar;

public class OrderBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(OrderBootstrapper.class);
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();


    @Override
    public boolean execute() {
        Customer customer1 = customerRepository.findByPK(25);
        Customer customer2 = customerRepository.findByPK(28);
        Customer customer3 = customerRepository.findByPK(31);

        NewOrder order = registerNewOrder("1","REGISTERED", Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer1, PaymentMethod.APPLE_PAY, ShipmentType.GREEN, 2562.05);
        registerNewOrder("2","BEING_PREPARED", Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer3, PaymentMethod.BANK_TRANSFER, ShipmentType.BLUE, 34.60);
        registerNewOrder("3","REGISTERED", Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer2, PaymentMethod.CREDIT_CARD, ShipmentType.STANDARD, 98.14);
        registerNewOrder("4","ALREADY_BEEN_PREPARED_BY_THE_AGV", Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer3, PaymentMethod.CREDIT_CARD, ShipmentType.STANDARD, 971.05);
        registerNewOrder("5","ALREADY_BEEN_PREPARED_BY_THE_AGV", Calendar.getInstance(), OrderClerk.valueOf("SALES_CLERK"), customer1, PaymentMethod.BANK_TRANSFER, ShipmentType.GREEN, 1283.05);

        return true;
    }

    private NewOrder registerNewOrder(String id, String status, Calendar date, OrderClerk clerk, Customer customer, PaymentMethod payment_method, ShipmentType shipment, double price) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE);

        final NewOrder order = new NewOrder(OrderID.valueOf(id), Status.valueOf(status), Calendar.getInstance(), clerk, customer, payment_method, shipment, price);

        NewOrder order1;

        try {
            order1 = orderRepository.save(order);
            assert order1 != null;
            return order1;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", order.identity());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }
}
