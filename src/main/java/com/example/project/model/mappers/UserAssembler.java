package com.example.project.model.mappers;

import com.example.project.model.dto.UserDTO;
import com.example.project.model.entities.User;
import com.example.project.model.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setUserProfileId(user.getUserProfile().getId());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserProfile(userProfile);
        return user;
    }
}

