package com.example.project.model.dto;

import com.example.project.model.data.ds.WorkingHours;

import java.util.List;

public class CosmetologistDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<Long> procedureIds;
    private WorkingHours availability;

    public CosmetologistDTO() {}

    public CosmetologistDTO(Long id, String name, String email, String phone, List<Long> procedureIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.procedureIds = procedureIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getProcedureIds() {
        return procedureIds;
    }

    public void setProcedureIds(List<Long> procedureIds) {
        this.procedureIds = procedureIds;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone=phone;
    }

    public WorkingHours getAvailability() {
        return availability;
    }

    public void setAvailability(WorkingHours availability) {
        this.availability=availability;
    }
}

