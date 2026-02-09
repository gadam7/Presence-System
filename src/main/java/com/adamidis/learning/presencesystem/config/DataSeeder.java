package com.adamidis.learning.presencesystem.config;

import com.adamidis.learning.presencesystem.model.*;
import com.adamidis.learning.presencesystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private ClassroomRepository classroomRepository;

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

                if (classroomRepository.count() == 0) {
                    Instructor adminProfileReloaded = instructorRepository.findAll().get(0);
                    Instructor instructorProfileReloaded = instructorRepository.findAll().get(1);
                    Lesson javaBasics = lessonsRepository.findAll().get(0);
                    Lesson springBoot = lessonsRepository.findAll().get(1);

                    Classroom classroom1 = new Classroom();
                    classroom1.setClassName("Java 101 - Morning Session");
                    classroom1.setClassDate(LocalDate.of(2026, 2, 15));
                    classroom1.setClassTime(LocalTime.of(9, 0));
                    classroom1.setInstructor(adminProfileReloaded);
                    classroom1.setLesson(javaBasics);

                    Classroom classroom2 = new Classroom();
                    classroom2.setClassName("Spring Boot - Afternoon Session");
                    classroom2.setClassDate(LocalDate.of(2026, 2, 16));
                    classroom2.setClassTime(LocalTime.of(14, 0));
                    classroom2.setInstructor(instructorProfileReloaded);
                    classroom2.setLesson(springBoot);

                    classroomRepository.save(classroom1);
                    classroomRepository.save(classroom2);

                    System.out.println("DB seeded with default classrooms.");
                }
            }
        }
    }
}
