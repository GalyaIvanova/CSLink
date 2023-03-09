package com.example.project._recactor.controller.service;

import com.example.project.user.model.dto.UserProfileDTO;
import com.example.project.user.model.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile getUserProfileById(Long id);

    UserProfileDTO createUserProfile(UserProfile userProfile);

    UserProfileDTO updateUserProfile(Long id, UserProfile userProfileDetails);

    void deleteUserProfile(Long id);

    List<UserProfileDTO> getAllUserProfiles();
}

