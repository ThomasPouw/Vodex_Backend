package abibliophobia.vodex.Login;
import abibliophobia.vodex.Database.Register_Database;
import abibliophobia.vodex.Database.Login_Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class Register_Login
{
    public String[] RegisterNewUser(String UserName, String Password, String Email, String Birthday)
    {
        Register_Database R_Database = new Register_Database();
        //Encrypt password :)
        try{
            if(CheckAge(Birthday)){
                Boolean Success = R_Database.Add_New_User(UserName, Password, Email, Birthday);
                if(Success)
                {
                    return Login(Email, Password);
                }
                else{
                    return new String[]{"0", "", "ErrorRegisterDatabase"};
                }

            }
            else{
                return new String[]{"0", "", "Below13"};
            }
        }
        catch(Exception E){
            System.out.println(E.getMessage());
        }
        return null;
    }
    public Boolean CheckAge(String Birthday){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
            Date Born = sdf.parse(Birthday);
            Date now = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            calendar.add(Calendar.YEAR, -13);
            return Born.before(calendar.getTime());
        }
        catch(ParseException P){
            System.out.println(P.getMessage());
            System.out.println(P.getCause());
            return false;
        }

    }
    public String[] Login(String Email, String Password)
    {
        Login_Database L_Database = new Login_Database();
        return L_Database.Login(Email, Password);
    }
    //Research password salt + hash java
}
