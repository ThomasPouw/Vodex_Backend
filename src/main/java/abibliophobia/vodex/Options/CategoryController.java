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
    Boolean AddNewMainCategory(@PathVariable String Category_Name){
        return Category_Database.AddNewCategory(Category_Name, null);
    }
    @GetMapping("/Sub/Add/{Category_Name}/{Main_Category_ID}")
    Boolean AddNewSubCategory(@PathVariable String Category_Name, @PathVariable String Main_Category_ID){
        return Category_Database.AddNewCategory(Category_Name, Main_Category_ID);
    }
    @GetMapping("{Type}/Delete{Category_Name}")
    Boolean DeleteCategory(@PathVariable String Type, @PathVariable String Category_Name){
        return Category_Database.DeleteCategory(Category_Name, Type);
    }
    @GetMapping("/Edit/{Category_Name}/{ID}")
    Boolean EditCategory(@PathVariable String Category_Name, @PathVariable String ID){
        return Category_Database.EditCategory(Category_Name, ID);
    }

}
