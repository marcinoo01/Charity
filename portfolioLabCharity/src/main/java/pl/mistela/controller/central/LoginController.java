package pl.mistela.controller.central;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mistela.model.User;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute(new User());
        return "forms/login";
    }

}
