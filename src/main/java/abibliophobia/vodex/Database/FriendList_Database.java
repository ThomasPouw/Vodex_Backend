package abibliophobia.vodex.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendList_Database extends DatabaseConfig{
    public Boolean Delete_Friend_Userside(int User_ID, int Friend_ID){
        try{
            PreparedStatement STMT = SetUpDatabase().prepareStatement("DELETE FROM User_Friends WHERE User_ID = ? AND Friend_ID = ? OR User_ID = ? AND Friend_ID = ? ");
            STMT.setInt(1, User_ID);
            STMT.setInt(2, Friend_ID);
            STMT.setInt(3, Friend_ID);
            STMT.setInt(4, User_ID);
            ResultSet result = STMT.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return true; //cahnge this abit
    }
    public String[] Get_List_Friends_From_User(int User_ID, int Friend_ID){
        try{
            PreparedStatement STMT = SetUpDatabase().prepareStatement("SELECT Image, User_ID, User_Name From User AS U INNER JOIN User_Friends AS UF On UF.User_ID = U.User_ID WHERE UF.User_ID = ?AND UF.Friend_ID = ?");
            STMT.setInt(1, User_ID);
            STMT.setInt(2, Friend_ID);
            ResultSet result = STMT.executeQuery();
            String[] FriendList = null;
            while(result.next())
            {
                FriendList = new String[]{result.getString(1), result.getString(2), result.getString(3)};
            }
            return FriendList;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
