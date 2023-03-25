package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Category;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.application.ParserJSON;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.repositories.AGVDocksRepository;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AGVDockBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(AGVDockBootstrapper.class);
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AGVDocksRepository agvDocksRepository = PersistenceContext.repositories().agvdocks();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();

    @Override
    public boolean execute() {
        Coordinates begin = new Coordinates(3,5);
        Coordinates end = new Coordinates(3,6);
        Coordinates depth = new Coordinates(3,7);
        Coordinates baseLocation = new Coordinates(3, 8);

        NewOrder neworder = orderRepository.findOrderByID(OrderID.valueOf("2"));

        AGVDock agvDock = registerNewAGVDock("D7", "l+", null, null, null, "Autonomous robots built to serve their human overlords", "AGV Dock 1.0", 150, 200, null, "free", neworder);

        ParserJSON.parseWarehouse();

        return true;
    }

    private AGVDock registerNewAGVDock(String id, String accessibility, Coordinates begin, Coordinates end, Coordinates depth, String description, String agvModel, float carryWeight, float maxWeight, Coordinates baseLocation, String state, NewOrder neworder) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE);

        final AGVDock agvDock = new AGVDock(id, accessibility, begin, end, depth, description, agvModel, carryWeight, maxWeight, baseLocation, state, neworder);

        AGVDock agvDock1;

        try {
            agvDock1 = agvDocksRepository.save(agvDock);
            assert agvDock1 != null;
            return agvDock1;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", agvDock.identity());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }
}
