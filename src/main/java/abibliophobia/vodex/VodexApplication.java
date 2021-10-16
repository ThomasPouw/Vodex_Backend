package abibliophobia.vodex;


import abibliophobia.vodex.Repository.OptionRepository.Category.Category;
import abibliophobia.vodex.Repository.ProductRepository.ProductRepository;
import abibliophobia.vodex.Repository.UserRepository.UserRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VodexApplication {
    @Autowired
    public ProductRepository PRepository;
    @Autowired
    public UserRepository URepository;
    public static void main(String[] args) {
        Category C = new Category("Le Test");
        SpringApplication.run(VodexApplication.class, args);




    }
}
