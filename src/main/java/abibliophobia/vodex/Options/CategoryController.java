package abibliophobia.vodex.Options;

import abibliophobia.vodex.Database.Category_Database;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Options/Category")
public class CategoryController {
    @GetMapping("/Get/{ID}")
    List<String[]> GetAllMainCategories(@PathVariable String ID){
        return Category_Database.GetAllCategories(ID);
    }
    @GetMapping("/Main/Add/{Category_Name}")
    List<String[]> AddNewMainCategory(@PathVariable String Category_Name){
        Boolean Added = Category_Database.AddNewCategory(Category_Name, null);
        if(Added){
            return Category_Database.GetAllCategories(null);
        }
        return null;
    }
    @GetMapping("/Sub/Add/{Category_Name}/{Main_Category_ID}")
    List<String[]> AddNewSubCategory(@PathVariable String Category_Name, @PathVariable String Main_Category_ID){
        Boolean Added = Category_Database.AddNewCategory(Category_Name, Main_Category_ID);
        if(Added){
            return Category_Database.GetAllCategories(Main_Category_ID);
        }
        return null;
    }
    @GetMapping("{Type}/Delete/{Category_Name}/{Main_Category_ID}")
    List<String[]> DeleteCategory(@PathVariable String Type, @PathVariable String Category_Name,@PathVariable String Main_Category_ID){
        Boolean Deleted = Category_Database.DeleteCategory(Category_Name, Type);
        if(Deleted){
            return Category_Database.GetAllCategories(Main_Category_ID);
        }
        return null;
    }
    @GetMapping("/Edit/{Category_Name}/{ID}")
    List<String[]> EditCategory(@PathVariable String Category_Name, @PathVariable String ID){
        Boolean Edit = Category_Database.EditCategory(Category_Name, ID);
        if(Edit){
            return Category_Database.GetAllCategories(ID);
        }
        return null;
    }

}
