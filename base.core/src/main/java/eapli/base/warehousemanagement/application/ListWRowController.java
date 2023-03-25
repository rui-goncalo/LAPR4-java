package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.domain.WRow;
import eapli.base.warehousemanagement.repositories.WRowRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListWRowController {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final WRowRepository repo = PersistenceContext.repositories().wrows();

    public Iterable<WRow> allWRows() {
        auth.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER, BaseRoles.WAREHOUSE_EMPLOYEE);

        return repo.findAll();
    }
}