package pl.mistela.controller.central;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SuccessLoginController {
    @GetMapping("/successLogin")
    public String successLogin(HttpServletRequest req) {
        if (req.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        return "redirect:/user";
    }
}
