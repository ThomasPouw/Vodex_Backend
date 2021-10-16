package abibliophobia.vodex.Repository.OptionRepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;

public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {
    //public List<Company> GetAllCompany();
    //public Company GetCompany();
    
}
