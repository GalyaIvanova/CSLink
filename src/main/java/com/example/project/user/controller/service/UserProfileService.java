package com.example.project.user.controller.service;

import com.example.project.user.model.dto.UserProfileDTO;

import java.util.List;

public interface UserProfileService {

    UserProfileDTO getUserProfileById(Long id);
    UserProfileDTO validateUserProfileById(Long id);

    UserProfileDTO createUserProfile(UserProfileDTO userProfile);

    UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDetails);

    void deleteUserProfile(Long id);

    List<UserProfileDTO> getAllUserProfiles();
}

