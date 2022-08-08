package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RuleMem {
    private final Map<Integer, Rule> ruleMap = new ConcurrentHashMap<>();
    private final AtomicInteger ids = new AtomicInteger(0);

    public RuleMem() {
        int idsOne = ids.incrementAndGet();
        int idsTwo = ids.incrementAndGet();
        int idsThree = ids.incrementAndGet();
        ruleMap.put(idsOne, Rule.of(idsOne, "Две машины"));
        ruleMap.put(idsTwo, Rule.of(idsTwo, "Машина и человек"));
        ruleMap.put(idsThree, Rule.of(idsThree, "Машина и велосипед"));
    }

    public Collection<Rule> findAll() {
        return ruleMap.values();
    }

    public Rule findById(Integer id) {
        return ruleMap.get(id);
    }
}
