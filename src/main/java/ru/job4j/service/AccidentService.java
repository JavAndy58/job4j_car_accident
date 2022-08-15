package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;

    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public List<Accident> findAll() {
        List<Accident> rsl = new ArrayList<>();
        rsl.addAll(accidentRepository.findAll());
        return rsl;
    }

    public void add(Accident accident) {
        accidentRepository.save(accident);
    }

    public Optional<Accident> findById(int id) {
        return accidentRepository.findById(id);
    }

    public void update(Accident accident) {
        accidentRepository.save(accident);
    }
}
