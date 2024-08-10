package de.dengralaura.customerapi.adress;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
