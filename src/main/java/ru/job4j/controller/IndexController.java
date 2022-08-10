package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.repository.AccidentHibernate;
import ru.job4j.repository.AccidentJdbcTemplate;

@Controller
public class IndexController {
    private final AccidentJdbcTemplate accidentJdbcTemplate;

    public IndexController(AccidentJdbcTemplate accidentJdbcTemplate) {
        this.accidentJdbcTemplate = accidentJdbcTemplate;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentJdbcTemplate.getAll());
        return "index";
    }
}
