package abibliophobia.vodex.Login;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/Register")
@CrossOrigin
public class RegisterController {
    @GetMapping("/{Username}/{Password}/{Email}/{BirthDay}")
        String[] RegisterUser(@PathVariable(value= "Username") String Username, @PathVariable(value= "Password") String Password, @PathVariable(value= "Email") String Email, @PathVariable(value= "BirthDay") String BirthDay)
        {
            return new Register_Login().RegisterNewUser(Username, Password, Email, BirthDay);
        }
}
