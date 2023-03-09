package com.example.project._recactor.model.mappers;

import com.example.project._useless.dto.UserDTO;

import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

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

