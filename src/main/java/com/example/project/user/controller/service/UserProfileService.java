package com.example.project.user.controller.service;

import java.util.List;

import com.example.project.user.model.dto.UserProfileDTO;

public interface UserProfileService {

    UserProfileDTO getUserProfileById(Long id);

    UserProfileDTO validateUserProfile(UserProfileDTO userProfileDTO);

    UserProfileDTO createUserProfile(UserProfileDTO userProfile);

    UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDetails);

    void deleteUserProfile(Long id);

    List<UserProfileDTO> getAllUserProfiles();
}

