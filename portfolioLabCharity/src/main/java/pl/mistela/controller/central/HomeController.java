package pl.mistela.controller.central;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mistela.repository.DonationRepository;
import pl.mistela.repository.InstitutionRepository;


@Controller
public class HomeController {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public HomeController(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("quantity", donationRepository.sumQuantity());
        model.addAttribute("donation", donationRepository.countAllById());
        model.addAttribute("descriptions", institutionRepository.findAllByDescription());
        model.addAttribute("names", institutionRepository.findAllByName());
        model.addAttribute("amountInstitutions", institutionRepository.count());
        return "index";
    }
}
