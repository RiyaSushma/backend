package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.FacultyClass;

public interface FacultyRepository extends JpaRepository<FacultyClass, Long> {
}
