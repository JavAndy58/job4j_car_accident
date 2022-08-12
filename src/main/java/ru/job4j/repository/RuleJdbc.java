package ru.job4j.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;
import java.util.List;

@Repository
public class RuleJdbc {
    private final JdbcTemplate jdbc;

    @Autowired
    public RuleJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Rule> findAll() {
        return jdbc.query("SELECT * FROM Rule", new BeanPropertyRowMapper<>(Rule.class));
    }

    public Rule findById(int id) {
        return jdbc.queryForObject("SELECT * FROM Rule WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Rule.class));
    }
}
