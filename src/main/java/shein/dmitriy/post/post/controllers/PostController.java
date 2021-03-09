package shein.dmitriy.post.post.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shein.dmitriy.post.post.entytis.Liter;
import shein.dmitriy.post.post.services.LiterService;

import java.util.List;

@Controller
@RequestMapping("/")
public class PostController {
    private List literList;
    private LiterService literService;

    @Autowired
    public PostController(LiterService literService) {
        this.literService = literService;
    }

    @GetMapping
    public String fvfPage(Model model) {
        model.addAttribute("liter", new Liter());
        return "post_main";
    }

    @PostMapping("/form")
    public String newLiter(Liter liter, BindingResult result, Model model) {
        literService.add(liter, literList);
        model.addAttribute("liter", new Liter());
        return "redirect:/";
    }
}
