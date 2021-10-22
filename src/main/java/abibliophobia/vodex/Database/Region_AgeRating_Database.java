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

public class Region_AgeRating_Database {
    public static List<String[]> GetAllRegion_AgeRatings(String Reference_Region_ID){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        List<String[]> list = new ArrayList<>();
        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            BasicDBObject criteria = new BasicDBObject();
            if (Reference_Region_ID == null) {
                criteria.append("Type", "Region");
            }
            else {
                criteria.append("Type", "AgeRating");
                criteria.append("Reference_Region_ID", Reference_Region_ID);
            }
            MongoCursor<Document> Mdoc = database.getCollection("Region_AgeRating").find(criteria).iterator();
            while(Mdoc.hasNext())
            {
                Document doc = Mdoc.next();
                list.add(new String[]{doc.get("_id").toString(), (String)doc.get("Region_AgeRating_Name")});
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
        return null;
    }
    public static Boolean AddNewRegion_AgeRatings(String Region_AgeRating_Name, String Reference_Region_ID){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            InsertOneResult result;
            if(Reference_Region_ID == null)
            {
                result = database.getCollection("Region_AgeRating").insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("Region_AgeRating_Name", Region_AgeRating_Name)
                        .append("Type", "Main"));
            }
            else{
                result = database.getCollection("Category").insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("Category_Name", Region_AgeRating_Name)
                        .append("Type", "Sub")
                        .append("Reference_Region_ID", Reference_Region_ID));
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
    }
    public static Boolean EditRegion_AgeRatings(String Region_AgeRating_Name, String Reference_Region_ID){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        try {
            Document query = new Document().append("_id", Reference_Region_ID);
            Bson updates = Updates.combine(
                    Updates.set("Region_AgeRating_Name", Region_AgeRating_Name));
            UpdateOptions options = new UpdateOptions().upsert(true);
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            UpdateResult result = database.getCollection("Region_AgeRating").updateOne(query, updates, options);
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
        return false;
    }
    public static Boolean DeleteRegion_AgeRatings(String Region_AgeRating_ID, String Type){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            if(Type== "Region"){
                DeleteResult result = database.getCollection("Category").deleteMany(new Document("Reference_Region_ID", Region_AgeRating_ID));
                System.out.println("Amount of deleted rows: "+result.getDeletedCount());
            }
            DeleteResult result = database.getCollection("Category").deleteOne(new Document("_id", Region_AgeRating_ID));
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
        return false;
    }
}
