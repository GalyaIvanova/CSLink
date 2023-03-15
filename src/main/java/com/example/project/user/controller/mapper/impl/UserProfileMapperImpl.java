package com.example.project.user.controller.mapper.impl;

import com.example.project.user.controller.mapper.UserProfileMapper;
import com.example.project.user.model.dto.UserProfileDTO;
import com.example.project.user.model.entity.UserProfile;

import org.springframework.stereotype.Component;

@Component
public class UserProfileMapperImpl implements UserProfileMapper {
    @Override
    public UserProfileDTO toDtoModel(UserProfile entity) {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setId(entity.getId());
        userProfileDTO.setRole(entity.getRole());
        userProfileDTO.setName(entity.getName());
        userProfileDTO.setPhone(entity.getPhone());
        userProfileDTO.setEmail(entity.getEmail());

        return userProfileDTO;
    }

    @Override
    public UserProfile toEntity(UserProfileDTO dto) {
        UserProfile entity = new UserProfile();
        entity.setId(dto.getId());
        entity.setRole(dto.getRole());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}