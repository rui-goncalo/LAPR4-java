package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.*;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.utils.PasswordGenerator;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UseCaseController
public class RegisterCustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public Customer registerCustomer(final String firstName, final String lastName, final String name, final String gender,  final int extension, final int phone, final String vat, final String postalAddress, final String email, final int birthDate_year, final int birthDate_month, final int birthDate_day) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK);

        Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER);

        final var customer = new Customer(Name.valueOf(firstName, lastName), NameCustomer.valueOf(name), GenderCustomer.valueOf(gender), PhoneCustomer.valueOf(extension, phone), VATCustomer.valueOf(vat), postalAddress, EmailAddress.valueOf(email), BirthDateCustomer.valueOf(birthDate_year, birthDate_month, birthDate_day));
        userSvc.registerNewUser(email, "Customer1", firstName, lastName, email, roles);

        System.out.printf("The following customer was created: " + customer.toString() + "\n");

        return customerRepository.save(customer);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Iterable<Customer> customers() {
        return null;
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    public Customer findByVAT (String customer) {
        return customerRepository.findByVAT(customer);
    }

    public Customer findByPK(int pk) {
        return customerRepository.findByPK(pk);
    }
}
