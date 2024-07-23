package com.example.service;
import com.example.model.UserClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.StudentRepository;
import com.example.model.StudentClass;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentProfileRepository;

    public StudentClass saveStudentProfile(StudentClass studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    public Optional<StudentClass> findById(Long id) {
        return studentProfileRepository.findById(id);
    }

    public boolean deleteStudentProfile(Long id) {
        if(studentProfileRepository.existsById(id)) {
            studentProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<StudentClass> findAll() {
        return studentProfileRepository.findAll();
    }

    public StudentClass updateStudent(Long id, StudentClass studentDetails) {
        Optional<StudentClass> optionalStudent = studentProfileRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentClass student = optionalStudent.get();
            student.setPhoto(studentDetails.getPhoto());
            student.setDepartmentClass(studentDetails.getDepartmentClass());
            student.setYear(studentDetails.getYear());
            student.setUserId(studentDetails.getUserId());
            return studentProfileRepository.save(student);
        }
        return null;
    }

}
