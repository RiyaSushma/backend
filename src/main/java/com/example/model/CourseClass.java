package com.example.model;
import jakarta.persistence.*;

@Entity
public class CourseClass {
    @Id
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private DepartmentClass department;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable = false)
    private FacultyClass faculty;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentClass getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentClass department) {
        this.department = department;
    }

    public FacultyClass getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyClass faculty) {
        this.faculty = faculty;
    }
}
