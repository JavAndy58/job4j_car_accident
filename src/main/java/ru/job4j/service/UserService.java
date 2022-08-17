package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> rsl = new ArrayList<>();
        rsl.addAll(userRepository.findAll());
        return rsl;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
