package abibliophobia.vodex.Repository.ProductRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    //public List<Product> Get_100_Products();
    //public Product Get_Product_By_ID(int ID);
    //public List<Product> Get_Products_By_ID(int ID);
}
