package de.dengralaura.customerapi.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Page<Customer> findAllCustomers(Pageable pageable);

    Optional<Customer> findCustomerById(String id);

    List<CustomerOverview> findAllCustomerOverviews();

    Page<Customer> findCustomersByLastName(String lastName, Pageable pageable);

    Customer save(Customer customer);
}
