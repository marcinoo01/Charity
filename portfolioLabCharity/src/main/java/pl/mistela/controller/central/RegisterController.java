package pl.mistela.controller.central;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mistela.model.User;
import pl.mistela.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "forms/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@Valid User user, BindingResult result){
        if(result.hasErrors() || !user.getPassword().equals(user.getRetypePassword())){
            return "d";
        }else {
            userService.add(user);
            return "/";
        }
    }
}
