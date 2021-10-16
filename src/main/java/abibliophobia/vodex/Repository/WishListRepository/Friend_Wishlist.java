package abibliophobia.vodex.Repository.WishListRepository;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
public class Friend_Wishlist extends Wishlist{
    public Map<String, String> Products_With_Friends;
    public Map<String, String> Nicknamed_Friend_ID;
    public List<String> FriendList;
    public Friend_Wishlist(){super();}
    public Friend_Wishlist(String Owner_ID, String Wishlist_Name, Map<String, String> Products_With_Friends, Map<String, String> Nicknamed_Friend_ID, List<String> FriendList)
    {
        super(Owner_ID, Wishlist_Name);
        this.Products_With_Friends = Products_With_Friends;
        this.Nicknamed_Friend_ID = Nicknamed_Friend_ID;
        this.FriendList = FriendList;
    }

}
