package abibliophobia.vodex.Repository.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    //public User GetUserPageData(String ID);
    //public List<ArrayList<String>> GetFriendList(String ID);
    //public Boolean Delete_Friend(String User_ID, String Friend_ID);
    //public Boolean Update_FriendList(String User_ID);
}
