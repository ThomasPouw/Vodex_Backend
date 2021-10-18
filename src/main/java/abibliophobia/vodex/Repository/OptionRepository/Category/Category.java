package abibliophobia.vodex.Repository.OptionRepository.Category;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category{
    @Id
    public String ID;
    public String CategoryName;
    public Category(String CategoryName)
    {
        this.CategoryName = CategoryName;
    }
    public Category() {}

}

