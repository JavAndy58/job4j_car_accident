package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>();

    private AccidentMem() {
        accidents.put(1, new Accident(1, "Обгон", "Обгон свяже 80 км", "Красная"));
        accidents.put(2, new Accident(2, "Пешеход", "Угроза пешеходу", "Московская"));
    }

    public Collection<Accident>findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accidents.put(accidents.size(), accident);
    }
}
