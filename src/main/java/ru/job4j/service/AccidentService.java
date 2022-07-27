package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentMem;
import java.util.Collection;
import java.util.HashMap;

@Service
public class AccidentService {
    private final AccidentMem accidentMem = AccidentMem.instOf();

    public Collection<Accident> findAll() {
        return accidentMem.findAll();
    }

    public void create(Accident accident) {
        accidentMem.create(accident);
    }
}
