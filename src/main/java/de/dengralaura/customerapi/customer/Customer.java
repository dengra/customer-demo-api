package de.dengralaura.customerapi.customer;

import de.dengralaura.customerapi.adress.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;

    private Address address;

    private String country;
    private String dateOfBirth;
    private String gender;
    private String occupation;
    private String company;
    private int income;
    private String subscriptionStatus;
    private int loyaltyPoints;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Instant lastModifiedDate;

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
