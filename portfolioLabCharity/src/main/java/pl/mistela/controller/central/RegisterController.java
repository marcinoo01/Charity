package pl.mistela.controller.central;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mistela.model.User;
import pl.mistela.service.EmailServiceImplementation;
import pl.mistela.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;
    private final EmailServiceImplementation emailServiceImplementation;

    public RegisterController(UserService userService, EmailServiceImplementation emailServiceImplementation) {
        this.userService = userService;
        this.emailServiceImplementation = emailServiceImplementation;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "forms/register";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result){
        if(result.hasErrors() || !user.getPassword().equals(user.getRetypePassword())){
            return "redirect:/register";
        }else {
            emailServiceImplementation.sendSimpleMessage("mistel940@gmail.com", "subject", "text");
            userService.add(user);
            return "redirect:/";
        }
    }
}
