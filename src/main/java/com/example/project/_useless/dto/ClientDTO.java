package com.example.project._useless.dto;

import java.util.List;

public class ClientDTO {
    private Long id;
    private Long userProfileId;
    private Address address;
    private List<Long> cosmetologistIds;

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getCosmetologistIds() {
        return cosmetologistIds;
    }

    public void setCosmetologistIds(List<Long> cosmetologistIds) {
        this.cosmetologistIds = cosmetologistIds;
    }


    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

