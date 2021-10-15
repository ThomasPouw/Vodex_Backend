package abibliophobia.vodex.Login;
import abibliophobia.vodex.Database.Register_Database;
import abibliophobia.vodex.Database.Login_Database;


public class Register
{
    public String[] RegisterNewUser(String UserName, String Password, String Email, String Birthday)
    {
        Register_Database R_Database = new Register_Database();
        //Encrypt password :)
        String password = "";
        Boolean Success = R_Database.Add_New_User(UserName, Password, Email, Birthday);
        if(Success)
        {
            Login_Database L_Database = new Login_Database();
            return L_Database.Login(Email, Password);
        }
        return null;
    }
}
