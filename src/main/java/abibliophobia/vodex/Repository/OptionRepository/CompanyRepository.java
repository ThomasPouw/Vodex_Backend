package abibliophobia.vodex.Repository.OptionRepository;

import abibliophobia.vodex.Repository.UserRepository.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
    
}
