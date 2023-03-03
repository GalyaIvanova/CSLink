package com.example.project.model.mappers;

import com.example.project.controller.service.UserProfileService;
import com.example.project.model.dto.UserDTO;
import com.example.project.model.entities.User;
import com.example.project.model.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {
@Autowired
private UserProfileService userProfileService;
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        //userDTO.setUserProfileId(user.getUserProfile().getId());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        if(userDTO.getUserProfileId()!=null){
           // user.setUserProfile(userProfileService.getUserProfileById(userDTO.getUserProfileId()));
        }
        return user;
    }
}

