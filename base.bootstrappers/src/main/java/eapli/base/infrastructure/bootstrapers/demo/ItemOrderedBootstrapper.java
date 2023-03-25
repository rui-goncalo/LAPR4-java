package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.itemorderedmanagement.domain.ItemOrdered;
import eapli.base.itemorderedmanagement.domain.ItemOrderedID;
import eapli.base.itemorderedmanagement.repositories.ItemOrderedRepository;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

public class ItemOrderedBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(ItemOrderedBootstrapper.class);
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ItemOrderedRepository itemOrderedRepository = PersistenceContext.repositories().itemsOrdered();


    @Override
    public boolean execute() {
        ItemOrdered itemOrdered = registerItemOrdered("1", 2558.00, 2);
        registerItemOrdered("2", 96.99, 1);
        registerItemOrdered("3", 32.90, 10);
        registerItemOrdered("4", 969.90,10);
        registerItemOrdered("5", 1279.00,1);

        return true;
    }

    private ItemOrdered registerItemOrdered(String id, double price, int quantity) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        final ItemOrdered itemOrdered = new ItemOrdered(ItemOrderedID.valueOf(id), price, quantity);

        ItemOrdered itemOrdered1;

        try {
            itemOrdered1 = itemOrderedRepository.save(itemOrdered);
            assert itemOrdered1 != null;
            return itemOrdered1;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", itemOrdered.identity());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }
}
