package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;
import ru.job4j.service.AccidentService;
import ru.job4j.service.AccidentTypeService;
import ru.job4j.service.RuleService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AccidentController {
    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;
    private final RuleService ruleService;

    public AccidentController(AccidentService accidentService, AccidentTypeService accidentTypeService, RuleService ruleService) {
        this.accidentService = accidentService;
        this.accidentTypeService = accidentTypeService;
        this.ruleService = ruleService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        Collection<AccidentType> types = accidentTypeService.findAll();
        model.addAttribute("types", types);
        Collection<Rule> rules = ruleService.findAll();
        model.addAttribute("rules", rules);
        return "create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        return "update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ruleIds = req.getParameterValues("rIds");
        Set<Rule> rules = new HashSet<>();
        for (String id : ruleIds) {
            rules.add(ruleService.findById(Integer.parseInt(id)));
        }
        accident.setRules(rules);
        int typeId = Integer.parseInt(req.getParameter("tId"));
        accident.setType(accidentTypeService.findById(typeId));
        accidentService.add(accident);
        return "redirect:/index";
    }

    @PostMapping("/updateAccident")
    public String updateAccident(@ModelAttribute Accident accident) {
        accidentService.update(accident);
        return "redirect:/index";
    }
}
