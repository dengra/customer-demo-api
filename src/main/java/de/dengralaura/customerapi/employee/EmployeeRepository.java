package de.dengralaura.customerapi.employee;

import de.dengralaura.customerapi.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {


    @Query(value = "{'nationality': 'ES' }", fields = "{'lastName': 1}")
    List<Customer> findSpanishEmployeesAndProjectOnlyLastNames();
}
