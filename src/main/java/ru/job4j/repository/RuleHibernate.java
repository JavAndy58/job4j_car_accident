package ru.job4j.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.List;

@Repository
public class RuleHibernate implements TransactionStore {
    private final SessionFactory sf;

    public RuleHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Rule> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.Rule").list(), sf);
    }

    public Rule findById(int id) {
        return this.tx(session -> session.get(Rule.class, id), sf);
    }
}
