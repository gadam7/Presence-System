package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.model.Lesson;

import java.util.Set;

public interface LessonService {

    Set<Lesson> findAllLessons();

    Lesson findById(Integer id);

    Lesson save(Lesson lesson, Integer instructorId);

    Lesson update(Integer id, Lesson tempLesson);

    void delete(Integer id);
}
