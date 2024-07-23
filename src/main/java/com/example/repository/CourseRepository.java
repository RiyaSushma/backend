package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.CourseClass;

public interface CourseRepository extends JpaRepository<CourseClass, Long> {
}
