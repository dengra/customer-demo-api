package de.dengralaura.customerapi.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    public void cleanUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void testFindCustomerOverviews() {
        // Given
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com", "12345");
        Customer customer2 = new Customer("Jane", "Smith", "jane.smith@example.com", "12346");
        Customer savedCustomer1 = customerRepository.save(customer1);
        Customer savedCustomer2 = customerRepository.save(customer2);

        // When
        List<CustomerOverview> overviews = customerRepository.findCustomerOverviews();

        // Then
        assertNotNull(overviews);
        assertEquals(2, overviews.size());
        assertEquals("John", overviews.getFirst().getFirstName());
        assertEquals("Doe", overviews.getFirst().getLastName());
        assertEquals("john.doe@example.com", overviews.getFirst().getEmail());
        assertNull(overviews.getFirst().getGender());
    }


}
