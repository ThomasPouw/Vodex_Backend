package abibliophobia.vodex.Repository.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
  //public User findUserByID(String ID);
  //public User findUsersByUsernameLike(String Username);
 // public User findUsersByUsernameAndPassword(String Username, String Password);
}
