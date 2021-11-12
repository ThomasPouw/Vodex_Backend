package abibliophobia.vodex.Product;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import abibliophobia.vodex.Database.Product_Database;


@RestController
@RequestMapping(path = "api/v1/Product/")
@CrossOrigin
public class ProductController {
    @PostMapping("{Product}/{Company}/{Description}/{Picture}/{Category}/{SubCategory}/{AgeRating}")
    String AddProduct(@PathVariable(value= "Product") String Product, @PathVariable(value= "Company") String Company, @PathVariable(value= "Description") String Description, @Validated @PathVariable(value= "Picture") String Picture, @PathVariable(value= "Category") String Category, @PathVariable(value= "SubCategory") String SubCategory, @PathVariable(value= "AgeRating") String AgeRating){
        Boolean check = Product_Database.AddProduct(Product, Company, Description, Picture, Category, SubCategory, AgeRating);
        if(check){
            return "Your item is succesfully added";
        }
        return "Your item wasnt able to be added";
    }

}
