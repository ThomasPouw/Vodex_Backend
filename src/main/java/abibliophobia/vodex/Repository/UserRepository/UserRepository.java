package abibliophobia.vodex.Repository.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    //public User GetUserPageDataByID(String ID);
    //List<ArrayList<String>> GetFriendList(String ID);
    //Boolean Delete_Friend(String User_ID, String Friend_ID);
    //Boolean Update_FriendList(String User_ID);
}
