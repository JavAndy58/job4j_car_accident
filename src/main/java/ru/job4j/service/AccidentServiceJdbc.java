package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentJdbcTemplate;

import java.util.Collection;

@Service
public class AccidentServiceJdbc {
    private final AccidentJdbcTemplate accidentJdbcTemplate;

    public AccidentServiceJdbc(AccidentJdbcTemplate accidentJdbcTemplate) {
        this.accidentJdbcTemplate = accidentJdbcTemplate;
    }

    public Collection<Accident> getAll() {
        return accidentJdbcTemplate.getAll();
    }

    public void save(Accident accident) {
        accidentJdbcTemplate.save(accident);
    }
}
