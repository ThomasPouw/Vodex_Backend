package abibliophobia.vodex.Repository.OptionRepository.RegionAge;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class RegionAge{
    @Id
    private ObjectId ID;
    private String ReadID;
    private String RegionAgeName;
    private List<RegionAge> Age;
    // Region find
    @PersistenceConstructor
    public RegionAge(ObjectId ID, String RegionAgeName,List<RegionAge> Agecategory)
    {
        this.ReadID = ID.toString();
        this.RegionAgeName = RegionAgeName;
        this.Age = Agecategory;
    }
    @PersistenceConstructor
    public RegionAge(ObjectId ID, String RegionAgeName)
    {
        this.ReadID = ID.toString();
        this.RegionAgeName = RegionAgeName;
    }

    public RegionAge(String RegionAgeName) {
        this.RegionAgeName = RegionAgeName;
    }

    public String getReadID() {
        return ReadID;
    }

    public void setAge(List<RegionAge> ageCategory) {Age= ageCategory;}
    public List<RegionAge> getAge() {return Age;}
    public void setRegionAgeName(String regionAgeName) {RegionAgeName = regionAgeName;}
    public String getRegionAgeName() {return RegionAgeName;}

}
