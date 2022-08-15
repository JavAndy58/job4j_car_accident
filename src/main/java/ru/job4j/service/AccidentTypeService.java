package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentTypeService {
    private final AccidentTypeRepository accidentTypeRepository;

    public AccidentTypeService(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    public List<AccidentType> findAll() {
        List<AccidentType> rsl = new ArrayList<>();
        accidentTypeRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public AccidentType findById(int id) {
        return accidentTypeRepository.findById(id).get();
    }
}
