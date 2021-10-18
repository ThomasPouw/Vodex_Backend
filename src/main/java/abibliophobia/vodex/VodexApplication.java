package abibliophobia.vodex;

import abibliophobia.vodex.Repository.OptionRepository.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class VodexApplication implements CommandLineRunner {
    @Autowired
    public CategoryRepository CRepository;
    public static void main(String[] args) {
        SpringApplication.run(VodexApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

    }

}

