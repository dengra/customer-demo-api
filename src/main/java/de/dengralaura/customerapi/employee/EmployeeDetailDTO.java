package de.dengralaura.customerapi.employee;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDetailDTO {
    private String id;

    private String firstName;

    private String lastName;

    private String nationality;

    private LocalDate birthDate;

    EmployeeDetailDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.nationality = employee.getNationality();
        this.birthDate = employee.getBirthDate();
    }
}
