package abibliophobia.vodex.Database;

import abibliophobia.vodex.Repository.UserRepository.User;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

public class User_Database extends DatabaseConfig{
    public List<User> GetUsersFromFriendlistResult(Document doc) {
        List<User> friend = new ArrayList<>();
        Bson projectionFields = Projections.fields(
                Projections.include("_id", "User_Name", "Image"));
       // MongoCursor<Document> Friends = SetUpDatabase("Users").find(lt("runtime", 15))
       //         .projection(projectionFields)
        //        .sort(Sorts.descending("title")).iterator();
        try {
        } finally {
         //   Friends.close();
        }
        return null;
    }
}
