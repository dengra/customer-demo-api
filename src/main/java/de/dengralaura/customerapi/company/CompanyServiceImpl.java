package de.dengralaura.customerapi.company;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @Override
    public CompanyDetailDTO getCompanyDetailById(String id) {
        return repository.findById(id).map(CompanyMapper::toDetailDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
    }

    @Override
    public List<CompanyOverviewDTO> getAllCompanyOverviews() {
        return repository.findAll().stream().map(CompanyMapper::toOverviewDto).collect(Collectors.toList());
    }

    @Override
    public Company createCompany(CompanyCreationDTO companyCreationDTO) {
        if (companyCreationDTO.getId() != null) {
            Company foundExisting = findById(companyCreationDTO.getId());
            if (foundExisting != null) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Company already exists");
            }
        }
        Company company = CompanyMapper.toEntity(companyCreationDTO);
        return repository.save(company);
    }

    @Override
    public Company updateCompany(String id, CompanyDetailDTO companyDetailDto) {
        if (!Objects.equals(id, companyDetailDto.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Company id mismatch");
        }
        return repository.findById(id)
                .map(company -> {
                    company.setCompanyName(companyDetailDto.getCompanyName());
                    return repository.save(company);
                }).orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @Override
    public void deleteCompany(String id) {
        repository.deleteById(id);
    }
}
