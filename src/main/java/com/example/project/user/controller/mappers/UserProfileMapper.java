package com.example.project.user.controller.mappers;

import com.example.project.user.model.dto.UserProfileDTO;
import com.example.project.user.model.entity.UserProfile;

public interface UserProfileMapper {
    UserProfileDTO toDtoModel(UserProfile entity);

    UserProfile toEntity(UserProfileDTO dto);
}
