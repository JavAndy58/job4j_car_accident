package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeMem;
import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeMem accidentTypeMem;

    public AccidentTypeService(AccidentTypeMem accidentTypeMem) {
        this.accidentTypeMem = accidentTypeMem;
    }

    public Collection<AccidentType> findAll() {
        return accidentTypeMem.findAll();
    }

    public AccidentType findById(Integer id) {
        return accidentTypeMem.findById(id);
    }
}
