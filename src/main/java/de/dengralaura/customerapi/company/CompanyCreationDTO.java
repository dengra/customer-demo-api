package de.dengralaura.customerapi.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class CompanyCreationDTO {
    @Id
    private String id;
    private String companyName;
    private String industry;
    private String location;
    private int yearFounded;
    private String ceo;

    public CompanyCreationDTO() {}
}
