package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.model.Lesson;

import java.util.Set;

public interface LessonService {

    Set<Lesson> findAllLessons();

    Lesson findById(Integer id);

    Lesson save(Lesson lesson, Integer instructorId);
}
