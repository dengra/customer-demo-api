package de.dengralaura.customerapi.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CompanyOverviewDTO {
    @Id
    private String id;
    private String companyName;
    private String industry;
    private String location;
    private int yearFounded;
    private String ceo;
}
