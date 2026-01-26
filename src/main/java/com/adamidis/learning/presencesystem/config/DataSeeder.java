package com.adamidis.learning.presencesystem.config;

import com.adamidis.learning.presencesystem.model.Authority;
import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.Role;
import com.adamidis.learning.presencesystem.model.User;
import com.adamidis.learning.presencesystem.repository.AuthorityRepository;
import com.adamidis.learning.presencesystem.repository.InstructorRepository;
import com.adamidis.learning.presencesystem.repository.LessonsRepository;
import com.adamidis.learning.presencesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception { // String... means? varargs, allows passing multiple String arguments
        // Avoid duplicate users if re-run
        if (userRepository.count() == 0) {

            User admin = new User("admin", "Georgios", "Adamidis", "admin@java.net", passwordEncoder.encode("12345"));
            admin.setEnabled(true);
            userRepository.save(admin);

            Authority adminRole = new Authority();
            adminRole.setAuthority(Role.ROLE_ADMIN);
            adminRole.setUser(admin);
            authorityRepository.save(adminRole);

            Instructor adminProfile = new Instructor();
            adminProfile.setUser(admin);
            adminProfile.setBio("Entry Level in Java, Spring Boot.");
            instructorRepository.save(adminProfile);

            User user = new User("user1", "John", "Doe", "user1@java.net", passwordEncoder.encode("12345"));
            user.setEnabled(true);
            userRepository.save(user);

            Authority userRole = new Authority();
            userRole.setAuthority(Role.ROLE_USER);
            userRole.setUser(user);
            authorityRepository.save(userRole);

            User student = new User("user2", "Thomas", "Adamidis", "user2@java.net", passwordEncoder.encode("12345"));
            student.setEnabled(true);
            userRepository.save(student);

            Authority studentRole = new Authority();
            studentRole.setAuthority(Role.ROLE_STUDENT);
            studentRole.setUser(student);
            authorityRepository.save(studentRole);

            User instructor = new User("user3", "Nikos", "Kladis", "user3@java.net", passwordEncoder.encode("12345"));
            instructor.setEnabled(true);
            userRepository.save(instructor);

            Authority instructorRole = new Authority();
            instructorRole.setAuthority(Role.ROLE_INSTRUCTOR);
            instructorRole.setUser(instructor);
            authorityRepository.save(instructorRole);

            Instructor instructorProfile = new Instructor();
            instructorProfile.setUser(instructor);
            instructorProfile.setBio("Expert in Java, Spring Boot, and Microservices.");
            instructorRepository.save(instructorProfile);

            System.out.println("DB seeded with default users.");

            // Seed some lessons
            if (lessonsRepository.count() == 0) {
                lessonsRepository.save(new com.adamidis.learning.presencesystem.model.Lesson("Java Basics", "Introduction to Java programming."));
                lessonsRepository.save(new com.adamidis.learning.presencesystem.model.Lesson("Spring Boot", "Building applications with Spring Boot."));
                lessonsRepository.save(new com.adamidis.learning.presencesystem.model.Lesson("Microservices", "Designing microservices architecture."));
                System.out.println("DB seeded with default lessons.");

                adminProfile.getLessons().add(lessonsRepository.findAll().get(0));
                adminProfile.getLessons().add(lessonsRepository.findAll().get(1));
                instructorProfile.getLessons().addAll(lessonsRepository.findAll());
                instructorRepository.save(adminProfile);
                instructorRepository.save(instructorProfile);

                System.out.println("Assigned lessons to instructors.");
            }
        }
    }
}
