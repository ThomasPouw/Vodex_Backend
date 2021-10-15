package abibliophobia.vodex.Repository.WishListRepository;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

public class Wishlist{
    @Id
    public String id;
    public String Owner_ID;
    public String Wishlist_Name;
    public List<String> Product_IDs;
    //A connection between the Friend and the Product
    public Wishlist(){}
    public Wishlist(String Owner_ID, String Wishlist_Name,List<String> Product_IDs){
        this.Owner_ID = Owner_ID;
        this.Wishlist_Name = Wishlist_Name;
        this.Product_IDs = Product_IDs;
    }
    public Wishlist(String Owner_ID, String Wishlist_Name){
        this.Owner_ID = Owner_ID;
        this.Wishlist_Name = Wishlist_Name;
    }
}
