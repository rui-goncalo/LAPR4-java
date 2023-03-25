package eapli.base.warehousemanagement.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.domain.Warehouse;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ImportWarehouseController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Warehouse importWarehouse() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER, BaseRoles.WAREHOUSE_EMPLOYEE);

        return ParserJSON.parseWarehouse();
    }
}