package com.example.project._recactor.controller.service.implementations;

import com.example.project._recactor.controller.service.UserProfileService;
import com.example.project._recactor.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project._recactor.model.dao.UserProfileRepository;
import com.example.project.user.model.dto.UserProfileDTO;
import com.example.project.user.model.entity.UserProfile;
import com.example.project._recactor.model.mappers.UserProfileAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserProfileAssembler userProfileAssembler;

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
    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile", id));
    }

    @Override
    public UserProfileDTO createUserProfile(UserProfile userProfile) {
        return userProfileAssembler.toDtoModel(userProfileRepository.save(userProfile));
    }

    @Override
    public UserProfileDTO updateUserProfile(Long id, UserProfile userProfileDetails) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile",  id));
        userProfile.setName(userProfileDetails.getName());
        userProfile.setPhone(userProfileDetails.getPhone());
//        userProfile.setGender(userProfileDetails.getGender());
        return userProfileAssembler.toDtoModel(userProfileRepository.save(userProfile));

    }

    @Override
    public void deleteUserProfile(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("UserProfile",  id));
        userProfileRepository.delete(userProfile);
    }

    @Override
    public List<UserProfileDTO> getAllUserProfiles() {
        return null;
    }
}
