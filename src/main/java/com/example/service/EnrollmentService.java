package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.EnrollmentRepository;
import com.example.model.EnrollmentClass;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentClass saveEnrollment(EnrollmentClass enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Optional<EnrollmentClass> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public List<EnrollmentClass> findAll() {
        return enrollmentRepository.findAll();
    }
}
