package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.domain.Warehouse;
import eapli.base.warehousemanagement.repositories.WarehouseRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListWarehouseController {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final WarehouseRepository repo = PersistenceContext.repositories().warehouses();

    public Iterable<Warehouse> allWarehouses() {
        auth.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER, BaseRoles.WAREHOUSE_EMPLOYEE);

        return repo.findAll();
    }
}