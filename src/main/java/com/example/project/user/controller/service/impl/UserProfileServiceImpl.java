package com.example.project.user.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.exceptions.CustomResourceNotFoundException;
import com.example.project.user.controller.mappers.UserProfileMapper;
import com.example.project.user.controller.service.UserProfileService;
import com.example.project.user.model.dataccess.dao.UserProfileDao;
import com.example.project.user.model.dataccess.persistence.UserProfilePersistence;
import com.example.project.user.model.dto.UserProfileDTO;
import com.example.project.user.model.entity.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileRepository;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private UserProfilePersistence UserProfilePersistence;

    //    @Override
    //    public UserProfileDTO createUserProfile(UserProfile userProfile) {
    //
    //    }

    //    @Override
    //    public UserProfileDTO getUserProfile(Long id) {
    //        return userProfileAssembler.toDtoModel(getUserProfileById(id));
    //    }
    //
    //    @Override
    //    public UserProfileDTO getUserProfileByUserId(Long userId) {
    //        return userProfileAssembler.toDtoModel(userProfileRepository.findByUserId(userId));
    //    }
    //
    //    @Override
    //    public void updateUserProfile(Long id, UserProfile userProfileDetails) {
    //        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile",  id));
    //        userProfile.setName(userProfileDetails.getName());
    //        userProfile.setPhone(userProfileDetails.getPhone());
    ////        userProfile.setGender(userProfileDetails.getGender());
    //        userProfileRepository.save(userProfile);
    //    }

    @Override
    public UserProfileDTO getUserProfileById(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile", id));
        return userProfileMapper.toDtoModel(userProfile);
    }

    @Override
    public UserProfileDTO validateUserProfileById(Long id) {
        return userProfileMapper.toDtoModel(UserProfilePersistence.getExistingUser(id));
    }

    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO userProfile) {

        return userProfileMapper.toDtoModel(userProfileRepository.save(userProfileMapper.toEntity(userProfile)));
    }

    @Override
    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDetails) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile", id));
        userProfile.setName(userProfileDetails.getName());
        userProfile.setPhone(userProfileDetails.getPhone());
        //        userProfile.setGender(userProfileDetails.getGender());
        return userProfileMapper.toDtoModel(userProfileRepository.save(userProfile));

    }

    @Override
    public void deleteUserProfile(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile", id));
        userProfileRepository.delete(userProfile);
    }

    @Override
    public List<UserProfileDTO> getAllUserProfiles() {
        return null;
    }
}
