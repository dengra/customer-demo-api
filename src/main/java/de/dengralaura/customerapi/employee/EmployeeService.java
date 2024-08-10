package de.dengralaura.customerapi.employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeOverviewDTO> getAllEmployeeOverviews();

    Employee findById(String id);

    EmployeeDetailDTO getEmployeeDetailById(String id);

    Employee createEmployee(EmployeeCreationDTO employeeCreationDTO);

    Employee updateEmployee(String id, EmployeeDetailDTO employeeDetailDto);

    void deleteEmployee(String id);
}
