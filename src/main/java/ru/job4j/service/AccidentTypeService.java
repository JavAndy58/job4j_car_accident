package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeHibernate;
import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeHibernate accidentTypeHibernate;

    public AccidentTypeService(AccidentTypeHibernate accidentTypeHibernate) {
        this.accidentTypeHibernate = accidentTypeHibernate;
    }

    public Collection<AccidentType> findAll() {
        return accidentTypeHibernate.getAll();
    }

    public AccidentType findById(Integer id) {
        return accidentTypeHibernate.findById(id);
    }
}
