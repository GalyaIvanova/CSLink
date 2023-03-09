package com.example.project._recactor.model.mappers;

import com.example.project._recactor.controller.service.UserService;
import com.example.project.user.model.dto.UserProfileDTO;
import com.example.project.user.model.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileAssembler {
    @Autowired
    private UserService userService;
//    @Autowired
//    private UserAssembler userAssembler;

    public UserProfileDTO toDtoModel(UserProfile entity) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setId(entity.getId());
        userProfileDTO.setUserId(entity.getUser().getId());
        userProfileDTO.setRole(entity.getRole());
        userProfileDTO.setName(entity.getName());
        userProfileDTO.setPhone(entity.getPhone());
        userProfileDTO.setEmail(entity.getEmail());

        return userProfileDTO;
    }

    public UserProfile toEntity(UserProfileDTO dto) {
        UserProfile entity = new UserProfile();
        entity.setId(dto.getId());
        User user=userService.getUserById(dto.getUserId());
        entity.setUser(user);
        entity.setRole(dto.getRole());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}