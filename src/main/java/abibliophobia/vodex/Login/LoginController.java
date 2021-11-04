package abibliophobia.vodex.Login;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/Login/")
@CrossOrigin
public class LoginController
{
    @GetMapping("/{Email}/{Password}")
    String[] RegisterUser(@PathVariable(value= "Email") String Email, @PathVariable(value= "Password") String Password)
    {
        return new Register_Login().Login(Email, Password);
    }
}
