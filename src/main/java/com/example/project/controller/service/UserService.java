package com.example.project.controller.service;

import com.example.project.model.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    boolean isValid(UserDTO userDTO);
}
