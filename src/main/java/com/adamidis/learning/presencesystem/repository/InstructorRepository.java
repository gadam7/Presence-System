package com.adamidis.learning.presencesystem.repository;

import com.adamidis.learning.presencesystem.model.Instructor;
import com.adamidis.learning.presencesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    Instructor findByUser(User tempUser);
}
