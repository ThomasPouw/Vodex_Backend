package abibliophobia.vodex.Services.Options;

import abibliophobia.vodex.Repository.OptionRepository.Category.Category;
import abibliophobia.vodex.Repository.OptionRepository.Category.ICategory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService{
    @Autowired
    private ICategory ICA;

    public void SaveCategory(String Category_Name, String Main_Category_ID){
        if(Main_Category_ID != null){
            Category C = ICA.findCategoryByID(Main_Category_ID);
            List<Category> list = new ArrayList<>();
            if(C.getSubCategory() != null){
                list =C.getSubCategory();
            }
            list.add(new Category(new ObjectId(),Category_Name));
            C.setSubCategory(list);
            ICA.save(C);
        }
        else{
            ICA.save(new Category(Category_Name));
        }
    }
    public List<Category> FindCategory(){
        System.out.println(ICA.findAll());
        return ICA.findAll();
    }
    public boolean DeleteRegionAge(String ID, String ParentID){
        try{
            if(ParentID != null){
                Category Category = ICA.findCategoryByID(ParentID);
                List<Category> list = Category.getSubCategory();
                if(list.indexOf(ID) != -1) {
                    list.remove(list.indexOf(ID));
                    Category.setSubCategory(list);
                    ICA.save(Category);
                    return true;
                }
            }
            else{
                Category Category = ICA.findCategoryByID(ID);
                ICA.delete(Category);
                return true;
            }
        }
        catch(Exception E){
            System.out.println(E.getMessage());
            return false;
        }
        return false;
    }
}
