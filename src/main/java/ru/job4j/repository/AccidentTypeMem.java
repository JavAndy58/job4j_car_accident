package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccidentTypeMem {
    private final Map<Integer, AccidentType> types = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(0);

    public AccidentTypeMem() {
        int idsOne = ids.incrementAndGet();
        int idsTwo = ids.incrementAndGet();
        int idsThree = ids.incrementAndGet();
        types.put(idsOne, AccidentType.of(idsOne, "Две машины"));
        types.put(idsTwo, AccidentType.of(idsTwo, "Машина и человек"));
        types.put(idsThree, AccidentType.of(idsThree, "Машина и велосипед"));
    }

    public Collection<AccidentType> findAll() {
        return types.values();
    }

    public AccidentType findById(Integer id) {
        return types.get(id);
    }
}
