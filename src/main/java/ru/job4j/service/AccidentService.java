package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentJdbc;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentJdbc accidentJdbc;

    public AccidentService(AccidentJdbc accidentJdbc) {
        this.accidentJdbc = accidentJdbc;
    }

    public Collection<Accident> findAll() {
        return accidentJdbc.getAll();
    }

    public void create(Accident accident) {
        accidentJdbc.save(accident);
    }

    public Accident findById(Integer id) {
        return accidentJdbc.findById(id);
    }

    public void update(Accident accident) {
        accidentJdbc.update(accident);
    }
}
