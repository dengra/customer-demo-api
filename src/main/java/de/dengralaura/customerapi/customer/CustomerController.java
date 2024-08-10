package de.dengralaura.customerapi.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("overview")
    public List<CustomerOverview> findAllCustomerOverviews() {
        return service.findAllCustomerOverviews();
    }

    @GetMapping("search")
    public Page<Customer> findAllCustomerOverviewPage(@RequestParam String lastName) {
        return service.findCustomersByLastName(lastName, Pageable.unpaged());
    }


    @GetMapping("{customerId}")
    public Optional<Customer> findCustomerById(@PathVariable String customerId) {
        return service.findCustomerById(customerId);
    }

    @GetMapping
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return service.findAllCustomers(pageable);
    }

    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }
}
