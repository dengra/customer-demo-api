package de.dengralaura.customerapi.company;

import java.time.LocalDate;
import java.time.Period;

public class CompanyMapper {
    public static CompanyOverviewDTO toOverviewDto(Company company) {
        // todo map sample attributes
        return new CompanyOverviewDTO(company.getId(), company.getCompanyName(), company.getIndustry(), company.getLocation(), company.getYearFounded(), company.getCeo());
    }

    private static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static Company toEntity(CompanyCreationDTO companyCreationDTO) {
        return new Company(companyCreationDTO.getCompanyName(), companyCreationDTO.getIndustry(), companyCreationDTO.getLocation(), companyCreationDTO.getYearFounded(), companyCreationDTO.getCeo());
    }

    public static CompanyDetailDTO toDetailDto(Company company) {
        CompanyDetailDTO companyDetailDTO = new CompanyDetailDTO(company.getCompanyName(), company.getIndustry(), company.getCeo());
        return companyDetailDTO;
    }
}
