package abibliophobia.vodex.Repository.OptionRepository.Category;

import java.util.List;

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
