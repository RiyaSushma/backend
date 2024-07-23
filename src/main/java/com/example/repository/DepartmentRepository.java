package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.DepartmentClass;

public interface DepartmentRepository extends JpaRepository<DepartmentClass, Long> {
}
