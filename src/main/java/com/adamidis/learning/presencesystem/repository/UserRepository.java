package com.adamidis.learning.presencesystem.repository;

import com.adamidis.learning.presencesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
