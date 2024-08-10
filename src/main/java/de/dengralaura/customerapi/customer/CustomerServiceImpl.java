package de.dengralaura.customerapi.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<CustomerOverview> findAllCustomerOverviews() {
        return repository.findCustomerOverviews();
    }

    @Override
    public Page<Customer> findCustomersByLastName(String lastName, Pageable pageable) {
        return repository.findByLastName(lastName, pageable);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }


}
