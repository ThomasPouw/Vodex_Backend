package abibliophobia.vodex.Repository.UserRepository;

import org.springframework.data.annotation.Id;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    @Id
    public String ID;

    public String Username;
    public String Password;
    public String Email;
    public Date Birthday;
    public String Role;
    public String Image;
    public List<User> Friends;

    public User() {}

    public User(String UserName, String Password, String Email, Date Birthday, String Role, String Image) {
        this.Username = UserName;
        this.Password = Password;
        this.Email = Email;
        this.Birthday = Birthday;
        this.Role = Role;
        this.Image = Image;
        Friends = new ArrayList<>();
    }
    public boolean SetFriend(User U)
    {
        try{
            Friends.add(U);
            return true;
        }
        catch(Exception E)
        {
            System.out.println(E.getCause());
            System.out.println(E.getMessage());
            return false;
        }
    }
    public boolean DeleteFriend(User U)
    {
        try{
            Boolean Is_In_List= false;
            for (User F:Friends) {
                if(F.ID == U.ID){
                    Is_In_List = true;
                }
            }
            if(Is_In_List == true){
                Friends.remove(U);
            }
            return true;
        }
        catch(Exception E)
        {
            System.out.println(E.getCause());
            System.out.println(E.getMessage());
            return false;
        }
    }

    //@Override
    //public String toString() {
     //   return String.format(
    //            "Customer[id=%s, firstName='%s', lastName='%s']",
    //            id, firstName, lastName);
   // }
}
