package abibliophobia.vodex.Database;

import abibliophobia.vodex.Repository.OptionRepository.Category.Category;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class Product_Database {
    public static List<Object[]> GetAllProducts(){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        List<Object[]> list = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            MongoCursor<Document> Mdoc = database.getCollection("Product").find().iterator();
            while(Mdoc.hasNext())
            {
                Document doc = Mdoc.next();
                list.add(new Object[]{doc.get("_id").toString(), doc.get("Product_Name"), doc.get("Company_Name"), doc.get("Image"), doc.get("Category")});
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
    public static List<Object[]> GetAllProducts_Search(String Product, String Company, Object[][][] Category, String AgeRating){
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        List<Object[]> list = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            DBObject criteria = new BasicDBObject();
            if(Product != null){
                criteria.put("Product_Name", Product);
            }
            if(Company != null){
                criteria.put("Company_Name", Company);
            }
            if(Category[1].length != 0)
            {
                for (int i = 0; i < Category[1].length; i++)
                {
                    criteria.put("Category_ID.SubCategory_ID", Category[1][i]);
                }
            }
            else{
                criteria.put("Category.ID", Category[0]);
                if(Category[1] != null){
                }
            }
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            MongoCursor<Document> Mdoc = database.getCollection("Product").find().iterator();
            while(Mdoc.hasNext())
            {
                Document doc = Mdoc.next();
                list.add(new Object[]{doc.get("_id").toString(), doc.get("Product_Name"), doc.get("Company_Name"), doc.get("Image"), doc.get("Category")});
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
    public static Boolean AddProduct(String Product,String Company,String Description,String Picture,String Category,String SubCategory,String AgeRating)
    {
        String uri = "mongodb+srv://ThomasPouw:rAuHT59tpmLwTp51@cluster0.johjz.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        try{
            MongoDatabase database = mongoClient.getDatabase("Vodex");
            InsertOneResult result = database.getCollection("Product").insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("Product_Name", Product)
                    .append("Company_Name", Company)
                    .append("Description", Description)
                    .append("Picture", Picture)
                    .append("Category", Category)
                    .append("SubCategory", SubCategory)
                    .append("AgeRating", AgeRating));
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
        }
        catch(MongoException ME){
            System.out.println(ME.getMessage());
            return false;
        }
        finally {
            mongoClient.close();
        }
        return true;
    }

}
