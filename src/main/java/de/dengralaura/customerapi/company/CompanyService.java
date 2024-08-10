package de.dengralaura.customerapi.company;

import java.util.List;

public interface CompanyService {
    List<CompanyOverviewDTO> getAllCompanyOverviews();

    Company findById(String id);

    CompanyDetailDTO getCompanyDetailById(String id);

    Company createCompany(CompanyCreationDTO companyCreationDTO);

    Company updateCompany(String id, CompanyDetailDTO companyDetailDto);

    void deleteCompany(String id);
}
