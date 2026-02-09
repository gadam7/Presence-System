package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.Lesson;
import com.adamidis.learning.presencesystem.repository.InstructorRepository;
import com.adamidis.learning.presencesystem.repository.LessonsRepository;
import com.adamidis.learning.presencesystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Lesson update(Integer id, Lesson tempLesson) {
        // Ensure the lesson ID in the body is provided
        if (tempLesson.getId() == null) {
            throw new RuntimeException("Lesson id must not be null for update operation");
        }

        // Ensure the ID in the URL matches the ID in the body
        if (!id.equals(tempLesson.getId())) {
            throw new RuntimeException("Lesson id in path (" + id + ") does not match id in body (" + tempLesson.getId() + ")");
        }

        // Fetch existing lesson by ID
        Lesson lessonToUpdate = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find lesson id - " + id));

        // Update lesson fields
        lessonToUpdate.setTitle(tempLesson.getTitle());
        lessonToUpdate.setDescription(tempLesson.getDescription());

        // Save and return the updated lesson
        return lessonsRepository.save(lessonToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Lesson tempLesson = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find lesson id - " + id));
        Instructor tempInstructor = tempLesson.getInstructors()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Did not find instructor for lesson id - " + id));

        tempInstructor.getLessons().remove(tempLesson);
        lessonsRepository.delete(tempLesson);
    }
}