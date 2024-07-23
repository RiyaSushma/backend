package com.example.controller;
import com.example.model.StudentClass;
import com.example.model.UserClass;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired()
    private StudentService studentService;

    @GetMapping()
    public List<StudentClass> findAll() {
        return studentService.findAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentClass> findById(@PathVariable Long id) {
        Optional<StudentClass> optionalStudent = studentService.findById(id);
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        StudentClass studentClass = optionalStudent.get();
        return ResponseEntity.ok(studentClass);
    }

    @PostMapping
    public StudentClass saveStudentProfile(@RequestBody StudentClass studentClass) {
        return studentService.saveStudentProfile(studentClass);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<StudentClass> updateStudent(@PathVariable Long id, @RequestBody StudentClass studentDetails) {
        StudentClass updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Long id) {
        if(!studentService.deleteStudentProfile(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
