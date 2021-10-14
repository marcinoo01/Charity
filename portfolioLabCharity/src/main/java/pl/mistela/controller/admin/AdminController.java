package pl.mistela.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mistela.repository.DonationRepository;
import pl.mistela.repository.InstitutionRepository;

@Controller
public class AdminController {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public AdminController(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("quantity", donationRepository.sumQuantity());
        model.addAttribute("donation", donationRepository.countAllById());
        model.addAttribute("descriptions", institutionRepository.findAllByDescription());
        model.addAttribute("names", institutionRepository.findAllByName());
        model.addAttribute("amountInstitutions", institutionRepository.count());
        return "admin/central";
    }
}
