package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.domain.WAisle;
import eapli.base.warehousemanagement.repositories.WAisleRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListWAisleController {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final WAisleRepository repo = PersistenceContext.repositories().waisles();

    public Iterable<WAisle> allWAisles() {
        auth.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER, BaseRoles.WAREHOUSE_EMPLOYEE);

        return repo.findAll();
    }
}