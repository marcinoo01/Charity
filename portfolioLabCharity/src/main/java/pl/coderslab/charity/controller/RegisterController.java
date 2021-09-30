package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.User;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "forms/register";
    }
}
