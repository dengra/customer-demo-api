package de.dengralaura.customerapi.company;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    List<Company> findByYearFounded(int yearFounded);

}
