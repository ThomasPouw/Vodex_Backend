package abibliophobia.vodex.Options;

import abibliophobia.vodex.Database.Region_AgeRating_Database;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Options")
public class Region_AgeRatingController {
    @GetMapping("/Region_AgeRating/{ID}")
    List<String[]> GetAllRegion_AgeRating(@PathVariable String ID){
        return Region_AgeRating_Database.GetAllRegion_AgeRatings(ID);
    }
    @GetMapping("/Region/Add/{Region_Name}")
    Boolean AddNewMainCategory(@PathVariable String Region_Name){
        return Region_AgeRating_Database.AddNewRegion_AgeRatings(Region_Name, null);
    }
    @GetMapping("/Age/Add/{Age_Name}/{Region_ID}")
    Boolean AddNewAgeRating(@PathVariable String Age_Name, @PathVariable String Region_ID){
        return Region_AgeRating_Database.AddNewRegion_AgeRatings(Age_Name, Region_ID);
    }
    @GetMapping("{Type}/Delete/{Option_ID}")
    Boolean DeleteCategory(@PathVariable String Type, @PathVariable String Option_ID){
        return Region_AgeRating_Database.DeleteRegion_AgeRatings(Option_ID, Type);
    }
    @GetMapping("/Edit/{Option_Name}/{ID}")
    Boolean EditCategory(@PathVariable String Option_Name, @PathVariable String ID){
        return Region_AgeRating_Database.EditRegion_AgeRatings(Option_Name, ID);
    }

}
