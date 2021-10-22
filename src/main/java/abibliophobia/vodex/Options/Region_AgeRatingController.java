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
    List<String[]> AddNewRegion(@PathVariable String Region_Name){
        Boolean Added = Region_AgeRating_Database.AddNewRegion_AgeRatings(Region_Name, null);
        if(Added){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(null);
        }
        return null;
    }
    @GetMapping("/Age/Add/{Region_ID}/{Age_Name}")
    List<String[]> AddNewAgeRating(@PathVariable String Region_ID, @PathVariable String Age_Name){
        Boolean Added = Region_AgeRating_Database.AddNewRegion_AgeRatings(Age_Name, Region_ID);
        if(Added){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(Region_ID);
        }
        return null;
    }
    @GetMapping("/Region_AgeRating/{Type}/Delete/{Option_ID}")
    List<String[]> DeleteCategory(@PathVariable String Type, @PathVariable String Option_ID){
        Boolean Delete = Region_AgeRating_Database.DeleteRegion_AgeRatings(Option_ID, Type);
        if(Delete){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(Option_ID);
        }
        return null;
    }
    @GetMapping("/Region_AgeRating/Edit/{Option_Name}/{ID}")
    List<String[]> EditCategory(@PathVariable String Option_Name, @PathVariable String ID){
        Boolean Edit =Region_AgeRating_Database.EditRegion_AgeRatings(Option_Name, ID);
        if(Edit){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(ID);
        }
        return null;
    }

}
