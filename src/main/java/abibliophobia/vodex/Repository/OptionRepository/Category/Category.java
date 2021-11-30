package abibliophobia.vodex.Repository.OptionRepository.Category;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Category{
    @Id
    private ObjectId ID;
    private String ReadID;
    private String CategoryName;
    private List<Category> SubCategory;
    @PersistenceConstructor
    public Category(ObjectId ID, String CategoryName,List<Category> Subcategory)
    {
        this.ID = ID;
        this.CategoryName = CategoryName;
        this.SubCategory = Subcategory;
    }
    @PersistenceConstructor
    public Category(ObjectId ID, String CategoryName)
    {
        this.ID = ID;
        this.CategoryName = CategoryName;
    }
    public Category(String category_name) {
        this.CategoryName = category_name;
    }

    public void setSubCategory(List<Category> subCategory) {SubCategory = subCategory;}
    public void setCategoryName(String categoryName) {CategoryName = categoryName;}
    public String getCategoryName() {return CategoryName;}
    public List<Category> getSubCategory() {
        if (SubCategory == null) {
            return null;
        }
        return SubCategory;}

    public String getReadID() {return ID.toString();}
}

