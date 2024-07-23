package com.example.model;
import jakarta.persistence.*;

@Entity
public class FacultyClass {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "Id", nullable = false)
    private UserClass user;

    private String photo;

    @ManyToOne
    @MapsId
    @JoinColumn(name= "department_id", nullable = false)
    private DepartmentClass department_id;

    private String office_hours;

    // getter and setter


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserClass getUser() {
        return user;
    }

    public void setUser(UserClass user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public DepartmentClass getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(DepartmentClass department_id) {
        this.department_id = department_id;
    }

    public String getOffice_hours() {
        return office_hours;
    }

    public void setOffice_hours(String office_hours) {
        this.office_hours = office_hours;
    }
}
