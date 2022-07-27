package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@Repository
public class AccidentMem {
    private static final AccidentMem INST = new AccidentMem();
    private HashMap<Integer, Accident> accidents = new HashMap<>();

    private AccidentMem() {
        accidents.put(1, new Accident(1, "Обгон", "Обгон свяже 80 км", "Красная"));
        accidents.put(2, new Accident(2, "Пешеход", "Угроза пешеходу", "Московская"));
    }

    public static AccidentMem instOf() {
        return INST;
    }

    public Collection<Accident>findAll() {
        return accidents.values();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentMem that = (AccidentMem) o;
        return Objects.equals(accidents, that.accidents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidents);
    }

    @Override
    public String toString() {
        return "AccidentMem{"
                + "accidents=" + accidents
                + '}';
    }
}
