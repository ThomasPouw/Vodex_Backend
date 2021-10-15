package abibliophobia.vodex.Repository.OptionRepository;

import abibliophobia.vodex.Repository.UserRepository.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    public List<Company> GetAllCompany();
    public Company GetCompany();
    
}
