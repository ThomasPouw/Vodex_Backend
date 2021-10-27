package abibliophobia.vodex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@SpringBootApplication
public class VodexApplication{
    public static void main(String[] args) {
        SpringApplication.run(VodexApplication.class, args);
    }

}

