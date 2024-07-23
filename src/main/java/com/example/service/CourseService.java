package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.CourseRepository;
import com.example.model.CourseClass;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseClass saveCourse(CourseClass course) {
        return courseRepository.save(course);
    }

    public Optional<CourseClass> findById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<CourseClass> findAll() {
        return courseRepository.findAll();
    }
}
