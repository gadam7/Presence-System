package com.adamidis.learning.presencesystem.repository;

import com.adamidis.learning.presencesystem.model.Authority;
import com.adamidis.learning.presencesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    List<Authority> findByUser(User user);

    List<Authority> findByUserId(Integer userId);

    void deleteByUser(User user);

    void deleteByUserId(Integer userId);
}
