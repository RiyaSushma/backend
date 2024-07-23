package com.example.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Enrollment")
public class EnrollmentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseClass course;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentClass student;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseClass getCourse() {
        return course;
    }

    public void setCourse(CourseClass course) {
        this.course = course;
    }

    public StudentClass getStudent() {
        return student;
    }

    public void setStudent(StudentClass student) {
        this.student = student;
    }
}