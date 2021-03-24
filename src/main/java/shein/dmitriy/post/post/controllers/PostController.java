package shein.dmitriy.post.post.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shein.dmitriy.post.post.entytis.Liter;
import shein.dmitriy.post.post.services.LiterService;

@Controller
@RequestMapping("/")
public class PostController {
    private LiterService literService;

    @Autowired
    public PostController(LiterService literService) {
        this.literService = literService;
    }

    @GetMapping
    public String fvfPage(Model model) {
        model.addAttribute("liter", new Liter());
        model.addAttribute("liters", literService.getLiterList());
        return "post_main";
    }

    @PostMapping("/add")
    public String newLiter(Liter liter, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        literService.add(liter);
        return "redirect:/";
    }

    @PostMapping("/remove/{shpi}")
    public String remove(@PathVariable(value = "shpi") String shpi, Model model) {
        literService.remove(shpi);
        return "redirect:/";
    }

    @PostMapping("/clear")
    public String clear(Model model) {
        literService.clear();
        return "redirect:/";
    }
}
