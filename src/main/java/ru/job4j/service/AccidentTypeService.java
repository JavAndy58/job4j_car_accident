package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeJdbc;
import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeJdbc accidentTypeJdbc;

    public AccidentTypeService(AccidentTypeJdbc accidentTypeJdbc) {
        this.accidentTypeJdbc = accidentTypeJdbc;
    }

    public Collection<AccidentType> findAll() {
        return accidentTypeJdbc.findAll();
    }

    public AccidentType findById(Integer id) {
        return accidentTypeJdbc.findById(id);
    }
}
