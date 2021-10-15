package abibliophobia.vodex.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_Database extends DatabaseConfig
{
    public String[] Login(String Email, String Password)
    {
        try{
            PreparedStatement STMT = SetUpDatabase().prepareStatement("SELECT User_ID, User_Name, Role FROM `User` WHERE Password = ? AND Email = ?");
            STMT.setString(1,Password);
            STMT.setString(2,Email);
            ResultSet result = STMT.executeQuery();
            String[] S = null;
            while(result.next())
            {
                S = new String[]{result.getString(1), result.getString(2), result.getString(3)};
            }
            return S;
        }
        catch(SQLException SQL){
            System.out.println("SQLException: "+ SQL.getMessage());
            System.out.println("Error code: "+ SQL.getErrorCode());
            return null;
        }
    }
}
