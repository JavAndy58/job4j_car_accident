package ru.job4j.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;

import java.util.List;

@Repository
public class AccidentTypeHibernate implements TransactionStore {
    private final SessionFactory sf;

    public AccidentTypeHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<AccidentType> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.AccidentType").list(), sf);
    }

    public AccidentType findById(int id) {
        return this.tx(session -> session.get(AccidentType.class, id), sf);
    }
}
