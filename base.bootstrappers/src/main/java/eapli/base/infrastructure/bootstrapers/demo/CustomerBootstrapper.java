package eapli.base.infrastructure.bootstrapers.demo;


import eapli.base.customermanagement.domain.*;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class CustomerBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CustomerBootstrapper.class);
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final UserManagementService userManagementService = AuthzRegistry.userService();

    @Override
    public boolean execute() {
        Customer customer = registerCustomer("Tiago", "Pinto", "Tiago Pinto", "male", 351,913913913, "PT913913913", "Maia", "tiago@isep.ipp.pt", 1997, 9, 13);
        registerCustomer("Rui", "Goncalves", "Rui Goncalves", "male", 351, 919191919, "PT919191919", "Maia", "rui@isep.ipp.pt", 1996, 12, 6);
        registerCustomer("Hugo", "Carvalho", "Hugo Carvalho", "male", 351, 967676876, "PT112398746", "Porto", "hugo@isep.ipp.pt", 1998, 2, 23);


        return true;
    }

    private Customer registerCustomer(String firstName, String lastName, String name, String gender, int extension, int phone, String vat, String postalAddress, String email, int birthDate_year, int birthDate_month, int birthDate_day) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER);

        final Customer newCustomer = new Customer(Name.valueOf(firstName, lastName), NameCustomer.valueOf(name), GenderCustomer.valueOf(gender), PhoneCustomer.valueOf(extension, phone), VATCustomer.valueOf(vat), postalAddress, EmailAddress.valueOf(email), BirthDateCustomer.valueOf(birthDate_year, birthDate_month, birthDate_day));
        userManagementService.registerNewUser(email, "Customer1", firstName, lastName, email, roles);

        Customer customer1;

        try {
            customer1 = customerRepository.save(newCustomer);
            assert customer1 != null;
            return customer1;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newCustomer.identity());
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
    }
}
