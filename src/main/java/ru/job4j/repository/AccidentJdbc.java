package ru.job4j.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class AccidentJdbc {
    private final JdbcTemplate jdbc;

    @Autowired
    public AccidentJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Accident accident) {
        accident.setId(jdbc.update("INSERT INTO Accident (name, text, address, type_id) VALUES (?, ?, ?, ?) RETURNING id",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getType().getId()));
        updateAccidentRuleTable(accident);
    }

    public List<Accident> getAll() {
        return jdbc.query("SELECT a.id AS id, a.name AS name, text, address, t.id AS t_id, t.name AS t_name"
        + "FROM Accident a JOIN Accident_type t ON a.type_id = t.id", new AccidentMapper());
    }

    public Accident findById(int id) {
        return jdbc.query("SELECT * FROM Accident WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Accident.class))
                .stream().findAny().orElse(null);
    }

    public void update(Accident accident) {
        jdbc.update("UPDATE Accident SET name=?, text=?, address=?, type=?, rules=? WHERE id=?", accident.getName(),
                accident.getText(), accident.getAddress(), accident.getType(), accident.getRules(), accident.getId());
    }

    private void updateAccidentRuleTable(Accident accident) {
        for (Rule rule : accident.getRules()) {
            jdbc.update("INSERT INTO Accident_rule(accident_id, rule_id) VALUES (?, ?)",
                    accident.getId(), rule.getId());
        }
    }

    private class AccidentMapper implements RowMapper<Accident> {

        @Override
        public Accident mapRow(ResultSet rs, int i) throws SQLException {
            Accident accident = new Accident(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("text"),
                    rs.getString("address"),
                    new AccidentType(rs.getInt("t_id"), rs.getString("t_name"))
            );
            accident.setRules(Set.copyOf(
                    jdbc.query(
                            "select r.id as id, r.name as name from accident_rule ar "
                                    + "join rule r on r.id = ar.rule_id "
                                    + "where ar.accident_id = ?",
                            new Object[]{accident.getId()},
                            new BeanPropertyRowMapper(Rule.class)
                    ))
            );
            return accident;
        }
    }
}
