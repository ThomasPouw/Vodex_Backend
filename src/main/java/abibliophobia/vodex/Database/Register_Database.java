package abibliophobia.vodex.Database;

import com.mongodb.MongoException;
import com.mongodb.reactivestreams.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.reactivestreams.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.mongodb.reactivestreams.client.*;
import static com.mongodb.client.model.Filters.lt;

public class Register_Database extends DatabaseConfig
{
    public boolean Add_New_User(String UserName, String Password, String Email, String Birthday)
    {
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        try{
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            InsertOneResult result = database.getCollection("Users").insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("Email", Email)
                    .append("User_Name", UserName)
                    .append("Password", Password)
                    .append("Birthday", Birthday)
                    .append("Role", "User"));
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
            mongoClient.close();
        }
        catch(MongoException E){
            System.out.println("MongoException: "+ E.getMessage());
            System.out.println("Error code: "+ E.getCode());
            return false;
        }
        catch(Exception E){
            System.out.println("MongoException: "+ E.getMessage());
            System.out.println("Error code: "+ E.getCause());
            return false;
        }
        return true;
    }
}
