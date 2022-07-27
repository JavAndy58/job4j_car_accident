package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.AccidentService;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    private final AccidentService accidentService;

    public IndexController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<String> users = Arrays.asList("Petr", "Ivan", "Denis", "Olga");
        model.addAttribute("users", users);
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}
