package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {
    private final RuleRepository repository;

    public RuleService(RuleRepository repository) {
        this.repository = repository;
    }

    public List<Rule> findAll() {
        List<Rule> rsl = new ArrayList<>();
        repository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Rule findById(int id) {
        return repository.findById(id).get();
    }
}
