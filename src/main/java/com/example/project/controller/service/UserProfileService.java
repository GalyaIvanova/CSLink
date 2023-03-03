package com.example.project.controller.service;

import com.example.project.model.dto.UserProfileDTO;
import com.example.project.model.entities.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile getUserProfileById(Long id);

    UserProfileDTO createUserProfile(UserProfile userProfile);

    UserProfileDTO updateUserProfile(Long id, UserProfile userProfileDetails);

    void deleteUserProfile(Long id);

    List<UserProfileDTO> getAllUserProfiles();
}

