package de.dengralaura.customerapi.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    // Customer save(Customer customer);

    // List<Customer> findAll(Customer customer);

    // Customer findById(String id);

    // void deleteById(String id);

    Page<Customer> findByLastName(String lastName, Pageable pageable);

    List<Customer> countCustomerByCountry(String country);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByEmail(String email);

    List<Customer> findByFirstNameAndLastNameOrderByLastName(String firstName, String lastName);

    List<Customer> removeByFirstName(String firstName);

    List<Customer> deleteByFirstName(String firstName);

    Page<Customer> findByFirstNameAndLastNameOrderByLastName(String firstName, String lastName, Pageable pageable);


    @Query(value = "{}", fields = "{ firstName: 1, lastName: 1, email:  1 }")
    List<CustomerOverview> findCustomerOverviews();


}
