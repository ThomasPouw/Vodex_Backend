package abibliophobia.vodex.Database;

import com.mongodb.MongoException;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendList_Database extends DatabaseConfig{
    public Boolean Delete_Friend_Userside(int User_ID, int Friend_ID){
        try
        {
            Bson query = eq("title", "The Garbage Pail Kids Movie");
            //Ye... dont know yet. how to get the

            SetUpDatabase("Users").deleteOne(query);
            mongoClient.close();
        }
            catch(MongoException E){
                System.out.println("MongoException: "+ E.getMessage());
                System.out.println("Error code: "+ E.getCode());
        }
        return true; //change this abit
    }
    public String[] Get_List_Friends_From_User(String User_ID){
        try{
            Bson projectionFields = Projections.fields(
                    Projections.include("FriendList"),
                    Projections.excludeId());
            Object doc = SetUpDatabase("Users").find(eq("_id", User_ID)).projection(projectionFields).first();
            System.out.println(doc.getClass());

            //return FriendList;
        }
        catch (MongoException Mongo) {
            System.out.println("There is a mistake made:" + Mongo.getMessage());
            System.out.println("There is a mistake made:" + Mongo.getCode());
        }
        return null;
    }

}
