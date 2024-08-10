package de.dengralaura.customerapi.company;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public CompanyDetailDTO getCompanyDetails(@PathVariable String id) {
        return service.getCompanyDetailById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Company create(@RequestBody final CompanyCreationDTO companyCreationDTO) {
        return service.createCompany(companyCreationDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company update(@PathVariable("id") final String id, @RequestBody final CompanyDetailDTO companyDetailDto) {
        return service.updateCompany(id, companyDetailDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") final String id) {
        service.deleteCompany(id);
    }


    @GetMapping
    public List<CompanyOverviewDTO> getAllCompanyOverviews() {
        return service.getAllCompanyOverviews();
    }
}
