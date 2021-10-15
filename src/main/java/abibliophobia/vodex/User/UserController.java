package abibliophobia.vodex.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import abibliophobia.vodex.Database.FriendList_Database;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/User/{User_ID}")
@CrossOrigin
public class UserController
{
    //Get all the locations on where the system can find the rest of the data for the page. Had to do it this way because the Wishlist need different things then the Friendlist
    /*@GetMapping("{ID}")
    Map<String, Integer> GetAccountDataForUserPage(@PathVariable Integer ID)
    {
        System.out.println("Here");
        return "YES! FINALLY!";
    }*/
    //@GetMapping("Friends/Delete/{Friend_ID}")
    //String[] Delete_Friend_From_User(@PathVariable Integer User_ID, @PathVariable Integer Friend_ID)
    //{
    //    new FriendList_Database().Delete_Friend_Userside(User_ID, Friend_ID);

    //    return
   // }
    /*@GetMapping("/{ID}/Friends")
    String[] GetfInfo()
    {
        return "yedgd";
    }*/
}
