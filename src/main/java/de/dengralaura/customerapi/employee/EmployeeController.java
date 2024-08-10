package de.dengralaura.customerapi.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public EmployeeDetailDTO getEmployeeDetails(@PathVariable String id) {
        return service.getEmployeeDetailById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee create(@RequestBody final EmployeeCreationDTO employeeCreationDTO) {
        return service.createEmployee(employeeCreationDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@PathVariable("id") final String id, @RequestBody final EmployeeDetailDTO employeeDetailDto) {
        return service.updateEmployee(id, employeeDetailDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") final String id) {
        service.deleteEmployee(id);
    }

    @GetMapping
    public List<EmployeeOverviewDTO> getAllEmployeeOverviews() {
        return service.getAllEmployeeOverviews();
    }

}
