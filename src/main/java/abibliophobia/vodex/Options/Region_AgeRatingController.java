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
    @GetMapping("/Region_AgeRating/Get/{ID}")
    List<String[]> GetAllRegion_AgeRating(@PathVariable String ID){
        return Region_AgeRating_Database.GetAllRegion_AgeRatings(ID);
    }
    @GetMapping("/Region_AgeRating/Add/{Option_Name}/{Reference_Region_ID}")
    List<String[]> AddNewRegion_Age(@PathVariable String Option_Name, @PathVariable String Reference_Region_ID){
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
