package abibliophobia.vodex.Repository.ProductRepository;

import abibliophobia.vodex.Repository.OptionRepository.Category.Category;
import abibliophobia.vodex.Repository.OptionRepository.Company;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Product {
        @Id
        public String ID;

        public String ProductName;
        public Company Company;
        public List<Category> Category;
        public String Image;
        public String Description;
        public List<String> Links;

        public Product() {}

        public Product(String ProductName, Company Company, List<Category> Category, String Image,String Description, List<String> Links) {
            this.ProductName = ProductName;
            this.Company = Company;
            this.Category = Category;
            this.Image = Image;
            this.Description = Description;
            this.Links = Links;
        }
        //@Override
        //public String toString() {
        //    return "hi";
       // }
}
