package com.adamidis.learning.presencesystem.repository;

import com.adamidis.learning.presencesystem.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
