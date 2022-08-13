package ru.job4j.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;

import java.util.List;

@Repository
public class AccidentTypeHibernate {
    private final SessionFactory sf;

    public AccidentTypeHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<AccidentType> getAll() {
        try(Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType ", AccidentType.class)
                    .list();
        }
    }

    public AccidentType findById(int id) {
        try(Session session = sf.openSession()) {
            return session.get(AccidentType.class, id);
        }
    }
}
