package abibliophobia.vodex.Repository.OptionRepository.Category;

import abibliophobia.vodex.Repository.UserRepository.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    public List<Category> Get_All_Categories();
    public List<Integer> Get_All_SubCategories(String ID);
    public List<Category> Get_SubCategories_By_ID(String ID);
}
