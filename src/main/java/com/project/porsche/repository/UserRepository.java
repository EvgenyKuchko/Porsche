package com.project.porsche.repository;

import com.project.porsche.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);

    User findByLogin(String login);
}