package de.dengralaura.customerapi.employee;

import de.dengralaura.customerapi.nationality.NationalityMapper;
import java.time.LocalDate;
import java.time.Period;

public class EmployeeMapper {
    public static EmployeeOverviewDTO toOverviewDto(Employee employee) {
        int age = calculateAge(employee.getBirthDate());

        String nationality = NationalityMapper.getNationality(employee.getNationality());
        return new EmployeeOverviewDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), nationality, age);
    }

    private static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static Employee toEntity(EmployeeCreationDTO employeeCreationDTO) {
        return new Employee(employeeCreationDTO.getFirstName(), employeeCreationDTO.getLastName());
    }

    public static EmployeeDetailDTO toDetailDto(Employee entity) {
        return new EmployeeDetailDTO(entity);
    }
}
