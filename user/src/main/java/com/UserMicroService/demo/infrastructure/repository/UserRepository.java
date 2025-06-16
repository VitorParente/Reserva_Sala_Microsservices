package com.UserMicroService.demo.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UserMicroService.demo.domain.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String emailUser);
}