package com.example.model;
import jakarta.persistence.*;

@Entity
public class AdministratorClass {
    @Id
    private Long userId;

    private String photo;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private DepartmentClass department;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private UserClass user;

    // getters and setters


    public Long getUserId() {
        return userId;
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

    public DepartmentClass getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentClass department) {
        this.department = department;
    }

    public UserClass getUser() {
        return user;
    }

    public void setUser(UserClass user) {
        this.user = user;
    }
}
