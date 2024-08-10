package de.dengralaura.customerapi.employee;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public EmployeeDetailDTO getEmployeeDetailById(String id) {
        return repository.findById(id).map(EmployeeMapper::toDetailDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    @Override
    public List<EmployeeOverviewDTO> getAllEmployeeOverviews() {
        return repository.findAll().stream().map(EmployeeMapper::toOverviewDto).collect(Collectors.toList());
    }

    @Override
    public Employee createEmployee(EmployeeCreationDTO employeeCreationDTO) {
        if (employeeCreationDTO.getId() != null) {
            Employee foundExisting = findById(employeeCreationDTO.getId());
            if (foundExisting != null) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exists");
            }
        }
        Employee employee = EmployeeMapper.toEntity(employeeCreationDTO);
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(String id, EmployeeDetailDTO employeeDetailDto) {
        if (!Objects.equals(id, employeeDetailDto.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee id mismatch");
        }
        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(employeeDetailDto.getFirstName());
                    employee.setLastName(employeeDetailDto.getLastName());
                    employee.setNationality(employeeDetailDto.getNationality());
                    employee.setBirthDate(employeeDetailDto.getBirthDate());
                    return repository.save(employee);
                }).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}
