package abibliophobia.vodex.Repository.WishListRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends ReactiveMongoRepository<Wishlist, String> {
    //public Friend_Wishlist Get_Wishlist_From_Friend(String Owner_ID);
    //public Wishlist Get_Wishlist(String Owner_ID);

}
