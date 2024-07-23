package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.FacultyRepository;
import com.example.model.FacultyClass;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyProfileRepository;

    public FacultyClass saveFacultyProfile(FacultyClass facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public Optional<FacultyClass> findById(Long id) {
        return facultyProfileRepository.findById(id);
    }

    public void deleteFacultyProfile(Long id) {
        facultyProfileRepository.deleteById(id);
    }

    public List<FacultyClass> findAll() {
        return facultyProfileRepository.findAll();
    }
}
