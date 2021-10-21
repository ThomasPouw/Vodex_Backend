 package abibliophobia.vodex.Database;


import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class DatabaseConfig {
    protected MongoClient mongoClient;
    public MongoCollection<Document> SetUpDatabase(String Collection)
    {
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            this.mongoClient = mongoClient;
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            return database.getCollection(Collection);
        }
        catch(MongoException E){
            System.out.println("Something went wrong... please send this to the developer: "+E.getMessage());
            return null;
        }
    }

}
