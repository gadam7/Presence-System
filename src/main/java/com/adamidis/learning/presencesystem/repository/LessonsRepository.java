package com.adamidis.learning.presencesystem.repository;

import com.adamidis.learning.presencesystem.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepository extends JpaRepository<Lesson, Integer> {
}
