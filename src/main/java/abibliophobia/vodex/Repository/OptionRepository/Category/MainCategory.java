package abibliophobia.vodex.Repository.OptionRepository.Category;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class MainCategory extends Category{
    public List<Integer> Subcategory_List;
    public MainCategory(List<Integer> subcategory, String CategoryName){
        super(CategoryName);
        this.Subcategory_List = subcategory;

    }
    public MainCategory(){
        super();
    }
}
