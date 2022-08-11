package ru.job4j.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.List;

@Repository
public class AccidentJdbc {
    private final JdbcTemplate jdbc;

    @Autowired
    public AccidentJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Accident accident) {
        jdbc.update("INSERT INTO Accident VALUES(?, ?, ?, ? ,?)", accident.getName(), accident.getText(),
                accident.getAddress(), accident.getType(), accident.getRules());
    }

    public List<Accident> getAll() {
        return jdbc.query("SELECT * FROM Accident", new BeanPropertyRowMapper<>(Accident.class));
    }

    public Accident findById(int id) {
        return jdbc.query("SELECT * FROM Accident WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Accident.class))
                .stream().findAny().orElse(null);
    }

    public void update(Accident accident) {
        jdbc.update("UPDATE Accident SET name=?, text=?, address=?, type=?, rules=? WHERE id=?", accident.getName(),
                accident.getText(), accident.getAddress(), accident.getType(), accident.getRules(), accident.getId());
    }
}
