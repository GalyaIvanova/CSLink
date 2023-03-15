package com.example.project._useless._recactor.controller.service.implementations;

import org.springframework.stereotype.Service;

import com.example.project._useless._recactor.controller.service.UserService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    //
    //    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    //
    //    @Autowired
    //    private  UserAssembler userAssembler;
    //
    //    @Override
    //    public UserDTO createUser(UserDTO userDTO) {
    //        // Check if username is already taken
    //        if (userRepository.existsByUsername(userDTO.getUsername())) {
    //            throw new CustomBadRequestException("Username is already taken.");
    //        }
    //
    //        // Create new user entity
    //        User user = userAssembler.toEntity(userDTO);
    //        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    //
    //        // Save user to database
    //        User savedUser = userRepository.save(user);
    //
    //        // Return saved user as DTO
    //        return userAssembler.toDTO(savedUser);
    //    }
    //
    //    @Override
    //    public User getUserById(Long id) {
    //        // Find user by id
    //        User user = userRepository.findById(id)
    //                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + id));
    //
    //        // Convert user to DTO and return
    //        return user;
    //    }
    //
    //    @Override
    //    public UserDTO updateUser(Long id, UserDTO userDTO) {
    //        // Find user by id
    //        User user = userRepository.findById(id)
    //                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + id));
    //
    //        // Update user fields with values from DTO
    //        user.setUsername(userDTO.getUsername());
    //        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    //
    //        // Save user to database
    //        User savedUser = userRepository.save(user);
    //
    //        // Return saved user as DTO
    //        return userAssembler.toDTO(savedUser);
    //    }
    //
    //    @Override
    //    public void deleteUser(Long id) {
    //        // Find user by id
    //        User user = userRepository.findById(id)
    //                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + id));
    //
    //        // Delete user
    //        userRepository.delete(user);
    //    }
    //
    //    @Override
    //    public boolean isValid(UserDTO userDTO) {
    //        User user = userRepository.findByUsername(userDTO.getUsername());
    //
    //        if (user == null) {
    //            return false;
    //        }
    //
    //        return user.getPassword().equals(passwordEncoder.encode(userDTO.getPassword()));
    //    }
    //}

}