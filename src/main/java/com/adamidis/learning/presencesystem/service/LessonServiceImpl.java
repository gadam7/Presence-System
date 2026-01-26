package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.Lesson;
import com.adamidis.learning.presencesystem.repository.InstructorRepository;
import com.adamidis.learning.presencesystem.repository.LessonsRepository;
import com.adamidis.learning.presencesystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonsRepository lessonsRepository;

    private final UserRepository userRepository;

    private final InstructorRepository instructorRepository;

    public LessonServiceImpl(LessonsRepository lessonsRepository, UserRepository userRepository, InstructorRepository instructorRepository) {
        this.lessonsRepository = lessonsRepository;
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
    }

    public Set<Lesson> findAllLessons() {
        return lessonsRepository.findAll().stream()
                .collect(toSet());
    }

    @Override
    public Lesson findById(Integer id) {
        Lesson tempLesson = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find lesson id - " + id));
        return tempLesson;
    }

    @Override
    public Lesson save(Lesson lesson, Integer instructorId) {
        Instructor creatorInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Did not find instructor -" + instructorId));

        Lesson tempLesson = new Lesson();
        tempLesson.setInstructors(Set.of(creatorInstructor));
        tempLesson.setTitle(lesson.getTitle());
        tempLesson.setDescription(lesson.getDescription());

        creatorInstructor.getLessons().add(tempLesson);

        return lessonsRepository.save(tempLesson);
    }
}
