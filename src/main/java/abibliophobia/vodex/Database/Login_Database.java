package abibliophobia.vodex.Database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.InsertOneResult;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;


public class Login_Database extends DatabaseConfig
{
    public String[] Login(String Email, String Password)
    {
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            BasicDBObject criteria = new BasicDBObject();
            criteria.append("Email", Email);
            criteria.append("Password", Password);
            MongoCursor<Document> Mdoc = database.getCollection("Users").find(criteria).iterator();
            while(Mdoc.hasNext()){
                Document doc = Mdoc.next();
                return new String[]{doc.get("_id").toString(), (String) doc.get("User_Name"), (String) doc.get("Role")};
            }
            return null;
        }
        catch(MongoException Mongo){
            System.out.println("SQLException: "+ Mongo.getMessage());
            return null;
        }
        finally{
            mongoClient.close();
        }
    }
}
