package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.repository.CategoryRepository;

@Controller
public class FundationOrganizationController {

    private final CategoryRepository categoryRepository;

    public FundationOrganizationController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/foundation")
    public String foundation(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "foundation/selectCategory";
    }
}
