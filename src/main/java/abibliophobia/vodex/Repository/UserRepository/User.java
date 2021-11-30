package abibliophobia.vodex.Repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    public String ID;

    public String Username;
    public String Password;
    public String Email;
    public Date Birthday;
    public String Role;
    public String Image;
    public List<User> Friends;

    public User() {}

    public User(String UserName, String Password, String Email, Date Birthday, String Role) {
        this.Username = UserName;
        this.Password = Password;
        this.Email = Email;
        this.Birthday = Birthday;
        this.Role = Role;
    }
    public User(String ID, String UserName, String Image) {
        this.ID = ID;
        this.Username = UserName;
        this.Image = Image;
    }

}
