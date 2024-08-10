package de.dengralaura.customerapi.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "company")
public class Company {

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

    public Company(String company_name, String industry, String location, int yearFounded, String ceo) {

    }
}