package abibliophobia.vodex.Repository.OptionRepository.Category;

import abibliophobia.vodex.Repository.OptionRepository.RegionAge.RegionAge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategory extends MongoRepository<Category, String> {
    public List<Category> findAllBySubCategoryExists();
    Category findCategoryByID(String ID);
}
