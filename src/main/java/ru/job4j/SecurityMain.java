package ru.job4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityMain {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("secret");
        System.out.println(pwd);
    }
}
