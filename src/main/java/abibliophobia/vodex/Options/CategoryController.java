package abibliophobia.vodex.Options;

import abibliophobia.vodex.Database.Category_Database;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/Options/Category")
public class CategoryController {
    @GetMapping({"/Get/{ID}", "/Get/"})
    List<String[]> GetAllCategories(@PathVariable(required = false) String ID){
        return Category_Database.GetAllCategories(ID);
    }
    @GetMapping("/Main/Add/{Category_Name}/")
    List<String[]> AddNewMainCategory(@PathVariable String Category_Name){
        Boolean Added = Category_Database.AddNewCategory(Category_Name, null);
        if(Added){
            return Category_Database.GetAllCategories(null);
        }
        return null;
    }
    @GetMapping("/Sub/Add/{New_Category_Name}/{Main_Category_ID}/")
    List<String[]> AddNewSubCategory(@PathVariable String New_Category_Name, @PathVariable String Main_Category_ID){
        Boolean Added = Category_Database.AddNewCategory(New_Category_Name, Main_Category_ID);
        if(Added){
            return Category_Database.GetAllCategories(Main_Category_ID);
        }
        return null;
    }
    @GetMapping("{Type}/Delete/{Category_ID}/{Main_Category_ID}")
    List<String[]> DeleteCategory(@PathVariable String Type, @PathVariable String Category_ID,@PathVariable String Main_Category_ID){
        Boolean Deleted = Category_Database.DeleteCategory(Category_ID, Type);
        if(Deleted){
            return Category_Database.GetAllCategories(Main_Category_ID);
        }
        return null;
    }
    @GetMapping("/Edit/{Category_Name}/{Option_ID}/{Reference_Main_ID}")
    List<String[]> EditCategory(@PathVariable String Category_Name, @PathVariable String Option_ID, @PathVariable String Reference_Main_ID){
        Boolean Edit = Category_Database.EditCategory(Category_Name, Option_ID);
        if(Edit){
            return Category_Database.GetAllCategories(Reference_Main_ID);
        }
        return null;
    }

}
