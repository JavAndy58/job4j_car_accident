package ru.job4j.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.User;
import ru.job4j.repository.AuthorityRepository;
import ru.job4j.repository.UserRepository;
import ru.job4j.service.AuthorityService;
import ru.job4j.service.UserService;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService userService;
    private final AuthorityService authorityService;

    public RegControl(PasswordEncoder encoder, UserService userService, AuthorityService authorityService) {
        this.encoder = encoder;
        this.userService = userService;
        this.authorityService = authorityService;
    }

    @PostMapping("/reg")
    public String reqSave(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reqPage() {
        return "reg";
    }
}