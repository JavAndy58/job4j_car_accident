package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger(0);

    private AccidentMem() {
        int idsOne = ids.incrementAndGet();
        int idsTwo = ids.incrementAndGet();
        accidents.put(idsOne, new Accident(idsOne, "Обгон", "Обгон свяже 80 км", "Красная", null));
        accidents.put(idsTwo, new Accident(idsTwo, "Пешеход", "Угроза пешеходу", "Московская", null));
    }

    public Collection<Accident>findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accident.setId(ids.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(Integer id) {
        return accidents.get(id);
    }

    public void update(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }
}
