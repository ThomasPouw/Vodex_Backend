package abibliophobia.vodex.Repository.ProductRepository;

import abibliophobia.vodex.Repository.UserRepository.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> Get_100_Products();
    public Product Get_Product_By_ID(int ID);
    public List<Product> Get_Products_By_ID(int ID);
}
