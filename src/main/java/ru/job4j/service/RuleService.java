package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleMem;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleMem ruleMem;

    public RuleService(RuleMem ruleMem) {
        this.ruleMem = ruleMem;
    }

    public Collection<Rule> findAll() {
        return ruleMem.findAll();
    }

    public Rule findById(Integer id) {
        return ruleMem.findById(id);
    }
}
