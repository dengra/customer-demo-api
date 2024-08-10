package de.dengralaura.customerapi.employee;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String nationality;

    private LocalDate birthDate;

    public Employee() {}

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
