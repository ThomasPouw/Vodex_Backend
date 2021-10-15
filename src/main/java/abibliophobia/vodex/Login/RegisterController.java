package abibliophobia.vodex.Login;

import org.springframework.web.bind.annotation.*;
import abibliophobia.vodex.Login.Register;

import java.util.Date;

@RestController
@RequestMapping(path = "api/v1/Register")
@CrossOrigin
public class RegisterController {
    @GetMapping("/{Username}/{Password}/{Email}/{BirthDay}")
        String[] RegisterUser(@PathVariable(value= "Username") String Username, @PathVariable(value= "Password") String Password, @PathVariable(value= "Email") String Email, @PathVariable(value= "BirthDay") String BirthDay)
        {
            return new Register().RegisterNewUser(Username, Password, Email, BirthDay);
        }
}
