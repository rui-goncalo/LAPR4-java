package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.repositories.CoordinatesRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListCoordinatesController {
    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final CoordinatesRepository repo = PersistenceContext.repositories().coordinates();

    public Iterable<Coordinates> allCoordinates() {
        auth.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MENU_MANAGER, BaseRoles.WAREHOUSE_EMPLOYEE);

        return repo.findAll();
    }
}