package pl.mistela.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mistela.repository.UserRepository;


@Controller
@RequestMapping("/admin/foundation")
public class AdminDeleteController {

    private final UserRepository userRepository;

    public AdminDeleteController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        userRepository.delete(userRepository.findById(id).get());
        return "redirect:/admin/foundation";
    }
}
