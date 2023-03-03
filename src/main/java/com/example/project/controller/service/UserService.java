package com.example.project.controller.service;

import com.example.project.model.dto.UserDTO;
import com.example.project.model.entities.User;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    User getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    boolean isValid(UserDTO userDTO);
}
