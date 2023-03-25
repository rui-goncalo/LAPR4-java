package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.ordermanagement.domain.Status;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.base.warehousemanagement.repositories.AGVDocksRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class ListAGVDockController {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final AGVDocksRepository repo = PersistenceContext.repositories().agvdocks();
    private final AGVService agvService = new AGVService();

    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();

    public Iterable<AGVDock> allAGVDocks() {
        auth.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER, BaseRoles.WAREHOUSE_EMPLOYEE);

        return repo.findAll();
    }

    public List<AGVDock> AGVByState(String state) {
        return repo.findAGVByState(state);
    }

    public void listAllAGVs(List<AGVDock> agvDockList) {
        agvService.printListAGVs(agvDockList);
    }

    public AGVDock AGVByID(String agvID) {
        return repo.findAGVByID(agvID);
    }

    public AGVDock agvPrepareOrder(AGVDock agvID, NewOrder orderID) {
        agvID.setOrder(orderID);
        agvID.setState("Occupied");
        repo.save(agvID);
        orderID.setStatus(Status.BEING_PREPARED);
        orderRepository.save(orderID);
        return agvID;
    }
}