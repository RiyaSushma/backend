package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.StudentClass;

public interface StudentRepository extends JpaRepository<StudentClass, Long> {

}
