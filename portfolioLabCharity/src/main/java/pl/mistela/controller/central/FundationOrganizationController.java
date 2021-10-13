package pl.mistela.controller.central;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mistela.model.Donation;
import pl.mistela.repository.CategoryRepository;
import pl.mistela.repository.DonationRepository;
import pl.mistela.repository.InstitutionRepository;

@Controller
public class FundationOrganizationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public FundationOrganizationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/foundation")
    public String foundation(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("foundations", institutionRepository.findAll());
        model.addAttribute("donation", new Donation());
        return "foundation/selectCategory";
    }

    @PostMapping("/foundation")
    public String foundation(Donation donation){
        donationRepository.save(donation);
        return "redirect:/";
    }
}
