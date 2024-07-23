package com.example.model;
import jakarta.persistence.*;

@Entity
public class StudentClass {
    @Id
    private Long userId;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserClass user_id;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private DepartmentClass departmentClass;


    private String photo;
    private String year;

    public Long getUserId() {
        return userId;
    }

    public UserClass getUser_id() {
        return user_id;
    }

    public void setUser_id(UserClass user_id) {
        this.user_id = user_id;
    }

    public DepartmentClass getDepartmentClass() {
        return departmentClass;
    }

    public void setDepartmentClass(DepartmentClass departmentClass) {
        this.departmentClass = departmentClass;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
