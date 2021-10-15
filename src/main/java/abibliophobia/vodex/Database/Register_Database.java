package abibliophobia.vodex.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Register_Database extends DatabaseConfig
{
    public boolean Add_New_User(String UserName, String Password, String Email, String Birthday)
    {
        try{
            PreparedStatement STMT = SetUpDatabase().prepareStatement("INSERT INTO `User`(`User_Name`, `Password`, `Email`, `Birthday`, `Role`) VALUES (?,?,?,?,'User')");
            STMT.setString(1,UserName);
            STMT.setString(2,Password);
            STMT.setString(3,Email);
            STMT.setString(4,Birthday);
            int number = STMT.executeUpdate();
            if(number != 1){
                throw new SQLException("Couldn't Insert User into Database");
            }
        }
        catch(SQLException SQL){
            System.out.println("SQLException: "+ SQL.getMessage());
            System.out.println("Error code: "+ SQL.getErrorCode());
            return false;
        }
        return true;
    }
}
