package abibliophobia.vodex.Database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BSONException;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Category_Database {
    public static List<String[]> GetAllCategories(String Main_Category_ID){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        List<String[]> list = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            BasicDBObject criteria = new BasicDBObject();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAH!:"+Main_Category_ID);
            if (Main_Category_ID == null) {
                criteria.append("Type", "Main");
            }
            else {
                criteria.append("Type", "Sub");
                criteria.append("Main_Category_ID", Main_Category_ID);
            }
            MongoCursor<Document> Mdoc = database.getCollection("Category").find(criteria).iterator();
            while(Mdoc.hasNext())
            {
                Document doc = Mdoc.next();
                list.add(new String[]{doc.get("_id").toString(), (String)doc.get("Category_Name")});
            }
            if(list.size() != 0)
            {
                return list;
            }
            return null;
        }
        catch(MongoException ME){
            System.out.println(ME.getMessage());

        }
        finally {
            mongoClient.close();
        }
        return null;
    }
    public static Boolean AddNewCategory(String Category_Name, String Main_Category_ID){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            InsertOneResult result;
            if(Main_Category_ID == null)
            {
                result = database.getCollection("Category").insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("Category_Name", Category_Name)
                        .append("Type", "Main"));
            }
            else{
                result = database.getCollection("Category").insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("Category_Name", Category_Name)
                        .append("Type", "Sub")
                        .append("Main_Category_ID", Main_Category_ID));
            }
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
            mongoClient.close();
            return true;
        }
        catch(MongoException E){
            System.out.println("MongoException: "+ E.getMessage());
            System.out.println("Error code: "+ E.getCode());
            return false;
        }
        finally{
            mongoClient.close();
        }
    }
    public static Boolean EditCategory(String Category_Name, String Category_ID){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            Document query = new Document().append("_id", Category_ID);
            Bson updates = Updates.combine(
                    Updates.set("Category_Name", Category_Name));
            UpdateOptions options = new UpdateOptions().upsert(true);
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            UpdateResult result = database.getCollection("Category").updateOne(query, updates, options);
            System.out.println(result.getModifiedCount());
            mongoClient.close();
            return true;
        }
        catch(MongoException E){
            System.out.println("MongoException: "+ E.getMessage());
            System.out.println("Error code: "+ E.getCode());
        }
        catch(BSONException BE){
            System.out.println("BsonException: "+BE.getMessage());
        }
        finally{
            mongoClient.close();
        }
        return false;
    }
    public static Boolean DeleteCategory(String Category_ID, String Type){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        try {

            MongoDatabase database = mongoClient.getDatabase("Vodex");
            if(Type== "Main"){
                DeleteResult result = database.getCollection("Category").deleteMany(new Document("Main_Category_ID", Category_ID));
                System.out.println("Amount of deleted rows: "+result.getDeletedCount());
            }
            DeleteResult result = database.getCollection("Category").deleteOne(new Document("_id", Category_ID));
            System.out.println("Amount of deleted rows: "+result.getDeletedCount());
            mongoClient.close();
            return true;
        }
        catch(MongoException E){
            System.out.println("MongoException: "+ E.getMessage());
            System.out.println("Error code: "+ E.getCode());
        }
        catch(BSONException BE){
            System.out.println("BsonException: "+BE.getMessage());
        }
        finally{
            mongoClient.close();
        }
        return false;
    }
}
