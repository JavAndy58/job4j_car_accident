package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CarAccidentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarAccidentApplication.class, args);
    }
}