package abibliophobia.vodex.Repository.OptionRepository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Company {
    @Id
    public String ID;
    public String Company_Name;
    public Company(){}
    public Company(String Company_Name)
    {
        this.Company_Name = Company_Name;
    }
}
