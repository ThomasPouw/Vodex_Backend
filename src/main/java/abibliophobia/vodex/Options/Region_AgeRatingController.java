package abibliophobia.vodex.Options;

import abibliophobia.vodex.Database.Category_Database;
import abibliophobia.vodex.Database.Region_AgeRating_Database;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/Options")
public class Region_AgeRatingController {
    @GetMapping({"/Region_AgeRating/Get/{ID}", "/Region_AgeRating/Get/"})
    List<String[]> GetAllRegion_AgeRating(@PathVariable(required = false) String ID){
        return Region_AgeRating_Database.GetAllRegion_AgeRatings(ID);
    }
    @GetMapping("/Region/Add/{Option_Name}/")
    List<String[]> AddNewRegionCategory(@PathVariable String Option_Name){
        Boolean Added = Region_AgeRating_Database.AddNewRegion_AgeRatings(Option_Name, null);
        if(Added){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(null);
        }
        return null;
    }
    @GetMapping("/AgeRating/Add/{Option_Name}/{Reference_Region_ID}/")
    List<String[]> AddNewAge(@PathVariable String Option_Name, @PathVariable String Reference_Region_ID){
        Boolean Added = Region_AgeRating_Database.AddNewRegion_AgeRatings(Option_Name, Reference_Region_ID);
        if(Added){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(Reference_Region_ID);
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
    @GetMapping("/Region_AgeRating/Edit/{Option_Name}/{Option_ID}/{Region_ID}")
    List<String[]> EditCategory(@PathVariable String Option_Name, @PathVariable String Option_ID,@PathVariable String Region_ID){
        Boolean Edit =Region_AgeRating_Database.EditRegion_AgeRatings(Option_Name, Option_ID);
        if(Edit){
            return Region_AgeRating_Database.GetAllRegion_AgeRatings(Region_ID);
        }
        return null;
    }

}
