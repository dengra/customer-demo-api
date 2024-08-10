package de.dengralaura.customerapi.employee;


import lombok.Data;


@Data
public final class EmployeeOverviewDTO {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String nationality;
    private final Integer age;

    public EmployeeOverviewDTO(String id, String firstName, String lastName, String nationality, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
    }


}
