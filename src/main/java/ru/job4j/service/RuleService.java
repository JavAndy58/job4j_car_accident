package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleHibernate;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleHibernate ruleHibernate;

    public RuleService(RuleHibernate ruleHibernate) {
        this.ruleHibernate = ruleHibernate;
    }

    public Collection<Rule> findAll() {
        return ruleHibernate.getAll();
    }

    public Rule findById(Integer id) {
        return ruleHibernate.findById(id);
    }
}
