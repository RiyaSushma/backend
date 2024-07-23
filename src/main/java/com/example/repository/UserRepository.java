package com.example.repository;
import com.example.model.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserClass, Long> {
    Optional<UserClass> findByUsername(String username);
}
