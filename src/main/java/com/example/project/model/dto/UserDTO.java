package com.example.project.model.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Long  userProfileId;

    public UserDTO() {
    }


    public UserDTO(Long id, String username, String password, Long userProfileId) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.userProfileId=userProfileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId=userProfileId;
    }
}