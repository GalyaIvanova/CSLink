package com.example.project.controller.service.implementations;

import com.example.project.controller.service.UserService;
import com.example.project.model.data.exceptions.CustomBadRequestException;
import com.example.project.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project.model.dto.UserDTO;
import com.example.project.model.entities.User;
import com.example.project.model.mappers.UserAssembler;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserAssembler userAssembler, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Check if username is already taken
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new CustomBadRequestException("Username is already taken.");
        }

        // Create new user entity
        User user = userAssembler.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Save user to database
        User savedUser = userRepository.save(user);

        // Return saved user as DTO
        return userAssembler.toDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        // Find user by id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + id));

        // Convert user to DTO and return
        return userAssembler.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // Find user by id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + id));

        // Update user fields with values from DTO
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Save user to database
        User savedUser = userRepository.save(user);

        // Return saved user as DTO
        return userAssembler.toDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        // Find user by id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + id));

        // Delete user
        userRepository.delete(user);
    }
}

