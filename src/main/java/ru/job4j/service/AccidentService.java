package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentMem;
import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public Collection<Accident> findAll() {
        return accidentMem.findAll();
    }

    public void create(Accident accident) {
        accidentMem.create(accident);
    }

    public Accident findById(Integer id) {
        return accidentMem.findById(id);
    }
}
