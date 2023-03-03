package com.example.project.model.dto;

import com.example.project.model.data.ds.Phone;
import com.example.project.model.data.enums.Role;

public class UserProfileDTO {
    private Long id;
    private Long userId;
    private Role role;
    private String name;
    private String email;
    private Phone phone;

    public UserProfileDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId=userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role=role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone=phone;
    }
}
