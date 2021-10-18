package abibliophobia.vodex.Repository.OptionRepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {
    
}
