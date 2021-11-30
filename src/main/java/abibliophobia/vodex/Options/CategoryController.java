package abibliophobia.vodex.Options;

import abibliophobia.vodex.Database.Category_Database;
import abibliophobia.vodex.Repository.OptionRepository.Category.Category;
import abibliophobia.vodex.Services.Options.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/Options/Category/")
@Controller
public class CategoryController {
    @Autowired
    private CategoryService CService;
    @GetMapping("Get/")
    List<Category> GetAllCategories(){
        List<Category> egg = CService.FindCategory();
        System.out.println();
        return egg;
    }
    @GetMapping("/Main/Add/{Category_Name}/")
    void AddNewMainCategory(@PathVariable String Category_Name){
        CService.SaveCategory(Category_Name, null);
    }
    @GetMapping("/Sub/Add/{Category_Name}/{Main_Category_ID}")
    void AddNewSubCategory(@PathVariable String Category_Name, @PathVariable String Main_Category_ID){
        CService.SaveCategory(Category_Name, Main_Category_ID);
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
