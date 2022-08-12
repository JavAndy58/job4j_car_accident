package ru.job4j.repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;

import java.util.List;

@Repository
public class AccidentTypeJdbc {
    private final JdbcTemplate jdbc;

    public AccidentTypeJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<AccidentType> findAll() {
        return jdbc.query("SELECT * FROM Accident_type", new BeanPropertyRowMapper<>(AccidentType.class));
    }

    public AccidentType findById(int id) {
        return jdbc.queryForObject("SELECT * FROM Accident_type WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(AccidentType.class));
    }
}
