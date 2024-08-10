package de.dengralaura.customerapi.company;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CompanyDetailDTO {

    @Id
    private String id;
    private String companyName;
    private String industry;
    private String location;
    private int numberOfEmployees;
    private long annualRevenue;
    private int yearFounded;
    private String ceo;
    private long marketCap;
    private String website;
    private String phoneNumber;
    private String email;
    private String primaryContact;
    private String contactTitle;
    private String country;
    private String customerSince;
    private double contractValue;
    private String preferredPaymentMethod;
    private String lastOrderDate;
    private String accountStatus;


    public CompanyDetailDTO(String companyName, String industry, String ceo) {
        this.companyName = companyName;
        this.industry = industry;
        this.ceo = ceo;
    }
}
