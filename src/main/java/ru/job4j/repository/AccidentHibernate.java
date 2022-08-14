package ru.job4j.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.List;

@Repository
public class AccidentHibernate implements TransactionStore {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident save(Accident accident) {
        this.tx(session -> session.save(accident), sf);
        return accident;
    }

    public List<Accident> getAll() {
        return this.tx(
                session -> session.createQuery("from ru.job4j.model.Accident").list(), sf);
    }

    public Accident findById(int id) {
        return this.tx(session -> session.get(Accident.class, id), sf);
    }

    public void update(Accident accident) {
        this.tx(session -> {
            session.update(accident);
            return new Object();
            }, sf
        );
    }
}
