package eapli.base.persistence.impl.inmemory;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.PhoneCustomer;
import eapli.base.customermanagement.domain.VATCustomer;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Integer> implements CustomerRepository{
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Customer> findAllCustomers(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return findAllCustomers();
    }

    @Override
    public Customer findByVAT(String customer) {
        return data().get(customer);
    }

    @Override
    public Customer findByPK(int pk) {
        return data().get(pk);
    }

}
