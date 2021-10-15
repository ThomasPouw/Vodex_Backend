package abibliophobia.vodex;


import abibliophobia.vodex.Repository.ProductRepository.ProductRepository;
import abibliophobia.vodex.Repository.UserRepository.UserRepository;
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
        SpringApplication.run(VodexApplication.class, args);
    }

}
