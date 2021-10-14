package pl.mistela.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mistela.repository.UserRepository;


@Controller
@RequestMapping("/admin/foundation")
public class AdminDeleteController {

    private final UserRepository userRepository;

    public AdminDeleteController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@RequestParam String id){
        userRepository.delete(userRepository.findById(Long.parseLong(id)).get());
        return "redirect:/admin/foundation";
    }
}
