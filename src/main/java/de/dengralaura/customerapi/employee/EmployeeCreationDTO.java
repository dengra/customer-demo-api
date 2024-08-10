package de.dengralaura.customerapi.employee;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class EmployeeCreationDTO {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    public EmployeeCreationDTO() {}
}
