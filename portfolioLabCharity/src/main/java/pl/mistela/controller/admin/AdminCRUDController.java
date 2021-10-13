package pl.mistela.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mistela.repository.InstitutionRepository;

@Controller
public class AdminCRUDController {
    private final InstitutionRepository institutionRepository;

    public AdminCRUDController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/admin/foundation")
    public String adminFoundation(Model model){
        model.addAttribute("descriptions",institutionRepository.findAllByDescription());
        model.addAttribute("names",institutionRepository.findAllByName());
        model.addAttribute("count",institutionRepository.count());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "admin/crud";
    }
}
