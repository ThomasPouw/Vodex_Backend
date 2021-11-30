package abibliophobia.vodex.Services.Options;

import abibliophobia.vodex.Repository.OptionRepository.RegionAge.IRegionAge;
import abibliophobia.vodex.Repository.OptionRepository.RegionAge.RegionAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class RegionAgeService{
    @Autowired
    public IRegionAge IRA;
    public void SaveRegionAge(String Region_AgeRating_Name, String Reference_Region_ID){
        if(Reference_Region_ID != null){
            RegionAge RA = IRA.findRegionAgeByID(Reference_Region_ID);
            List<RegionAge> list = RA.getAge();
            list.add(new RegionAge(Region_AgeRating_Name));
            RA.setAge(list);
            IRA.save(RA);
        }
        else{
            IRA.save(new RegionAge(Region_AgeRating_Name));
        }
    }
    public List<RegionAge> FindRegions(){
        return IRA.findAll();
    }
    public boolean DeleteRegionAge(String ID, String ParentID){
        try{
            if(ParentID != null){
                RegionAge Region = IRA.findRegionAgeByID(ParentID);
                List<RegionAge> list = Region.getAge();
                if(list.indexOf(ID) != -1) {
                    list.remove(list.indexOf(ID));
                    Region.setAge(list);
                    IRA.save(Region);
                    return true;
                }
            }
            else{
                RegionAge Region = IRA.findRegionAgeByID(ID);
                IRA.delete(Region);
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
