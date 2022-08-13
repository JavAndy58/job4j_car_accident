package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentHibernate;
import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentHibernate accidentHibernate;

    public AccidentService(AccidentHibernate accidentHibernate) {
        this.accidentHibernate = accidentHibernate;
    }

    public Collection<Accident> findAll() {
        return accidentHibernate.getAll();
    }

    public void create(Accident accident) {
        accidentHibernate.save(accident);
    }

    public Accident findById(Integer id) {
        return accidentHibernate.findById(id);
    }

    public void update(Accident accident) {
        accidentHibernate.update(accident);
    }
}
