package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.AccidentService;
import ru.job4j.service.AccidentServiceJdbc;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    private final AccidentServiceJdbc accidentServiceJdbc;

    public IndexController(AccidentServiceJdbc accidentServiceJdbc) {
        this.accidentServiceJdbc = accidentServiceJdbc;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accidents", accidentServiceJdbc.getAll());
        return "index";
    }
}
