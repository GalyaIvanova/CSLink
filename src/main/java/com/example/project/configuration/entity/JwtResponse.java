package com.example.project.configuration.entity;

import com.example.project.user.model.entity.UserProfile;

public class JwtResponse {

    private UserProfile user;
    private String jwtToken;

    public JwtResponse(UserProfile user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
