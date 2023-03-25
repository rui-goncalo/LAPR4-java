package eapli.base.customermanagement.repositories;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.PhoneCustomer;
import eapli.base.customermanagement.domain.VATCustomer;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;

import java.util.List;
import java.util.concurrent.CompletionService;

public interface CustomerRepository extends DomainRepository<Integer, Customer> {
    Iterable<Customer> findAllCustomers(Customer customer);

    public List<Customer> findAllCustomers();

    Customer findByVAT(String customer);

    Customer findByPK(int pk);
}
