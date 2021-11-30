package abibliophobia.vodex.Services.User;

//import abibliophobia.vodex.Repository.UserRepository.IUserRepository;
import abibliophobia.vodex.Repository.UserRepository.IUserRepository;
import abibliophobia.vodex.Repository.UserRepository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UserService {
    @Autowired
  public IUserRepository IUser;
  public void SaveUser(String Username, String Password, String Email, Date Birthday, String Role){
      IUser.save(new User(Username, Password, Email, Birthday, Role));
   }
   public User findLoginUser(String UserName, String Password){
      //return IUser.findUsersByUsernameAndPassword(UserName, Password);
       return null;
  }
}
