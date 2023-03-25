package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.VATCustomer;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaCustomerRepository extends JpaAutoTxRepository<Customer, Integer, Integer> implements CustomerRepository {
    public JpaCustomerRepository(TransactionalContext autoTx) {
        super(autoTx, "VAT");
    }

    public JpaCustomerRepository(String PUName) {
        super(PUName, Application.settings().getExtendedPersistenceProperties(), "VAT");
    }

    @Override
    public Iterable<Customer> findAllCustomers(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        TypedQuery<Customer> query = super.createQuery("SELECT DISTINCT c FROM Customer c", Customer.class);
        for (Customer c: query.getResultList()) {
            customers.add(c);
        }
        return customers;
    }

    @Override
    public Customer findByVAT(String VAT) {
        TypedQuery<Customer> query = super.createQuery("SELECT c FROM Customer c WHERE c.VAT = :VAT", Customer.class);
        query.setParameter("VAT", VAT);

        return query.getSingleResult();
    }

    @Override
    public Customer findByPK(int pk) {
        TypedQuery<Customer> query = super.createQuery("SELECT c FROM Customer c WHERE c.pk = :pk", Customer.class);
        query.setParameter("pk", pk);

        return query.getSingleResult();
    }
}
