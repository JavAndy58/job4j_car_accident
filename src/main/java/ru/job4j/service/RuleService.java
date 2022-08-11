package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleJdbc;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleJdbc accidentRuleJdbc;

    public RuleService(RuleJdbc accidentRuleJdbc) {
        this.accidentRuleJdbc = accidentRuleJdbc;
    }

    public Collection<Rule> findAll() {
        return accidentRuleJdbc.findAll();
    }

    public Rule findById(Integer id) {
        return accidentRuleJdbc.findById(id);
    }
}
