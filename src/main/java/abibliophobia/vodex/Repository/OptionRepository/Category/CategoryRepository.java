package abibliophobia.vodex.Repository.OptionRepository.Category;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

}
