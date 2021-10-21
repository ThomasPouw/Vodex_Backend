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

    public User(String UserName, String Password, String Email, Date Birthday, String Role, String Image) {
        this.Username = UserName;
        this.Password = Password;
        this.Email = Email;
        this.Birthday = Birthday;
        this.Role = Role;
        this.Image = Image;
        Friends = new ArrayList<>();
    }
    public User(String ID, String UserName, String Image) {
        this.ID = ID;
        this.Username = UserName;
        this.Image = Image;
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
                if (F.ID.equals(U.ID)) {
                    Is_In_List = true;
                    break;
                }
            }
            if(Is_In_List){
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
