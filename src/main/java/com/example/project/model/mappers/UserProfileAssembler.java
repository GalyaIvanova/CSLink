package com.example.project.model.mappers;

import com.example.project.model.dto.UserProfileDTO;
import com.example.project.model.entities.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileAssembler {

    public UserProfileDTO toDtoModel(UserProfile entity) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setId(entity.getId());
        userProfileDTO.setName(entity.getName());
        userProfileDTO.setPhone(entity.getPhone());
        userProfileDTO.setEmail(entity.getEmail());

        return userProfileDTO;
    }

    public UserProfile toEntity(UserProfileDTO dto) {
        UserProfile entity = new UserProfile();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}