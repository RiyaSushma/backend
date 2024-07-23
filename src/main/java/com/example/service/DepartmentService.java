package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.DepartmentRepository;
import com.example.model.DepartmentClass;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService  {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentClass saveDepartment(DepartmentClass department) {
        return departmentRepository.save(department);
    }

    public Optional<DepartmentClass> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<DepartmentClass> findAll() {
        return departmentRepository.findAll();
    }
}
