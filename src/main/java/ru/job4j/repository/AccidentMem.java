package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger(0);

    private AccidentMem() {
        accidents.put(1, new Accident(ids.incrementAndGet(), "Обгон", "Обгон свяже 80 км", "Красная"));
        accidents.put(2, new Accident(ids.incrementAndGet(), "Пешеход", "Угроза пешеходу", "Московская"));
    }

    public Collection<Accident>findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accidents.put(ids.incrementAndGet(), accident);
    }

    public Accident findById(Integer id) {
        return accidents.values().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }
}
