package com.adamidis.learning.presencesystem.repository;

import com.adamidis.learning.presencesystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
