package com.adamidis.learning.presencesystem;

import com.adamidis.learning.presencesystem.model.Role;
import com.adamidis.learning.presencesystem.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PresenceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresenceSystemApplication.class, args);
    }

}
