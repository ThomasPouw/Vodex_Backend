package abibliophobia.vodex.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    public Connection SetUpDatabase()
    {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Cannot Load the Driver!");
            System.out.println("SQLException: " + ex.getMessage());
            return null;
        }
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/rhGPCBzllW" +
                    "?user=rhGPCBzllW&password=9ip9Ym5PRf");
            return conn;
        }
        catch(Exception E)
        {
            System.out.println("Connection error:"+ E.getMessage());
            return null;
        }
    }

}
