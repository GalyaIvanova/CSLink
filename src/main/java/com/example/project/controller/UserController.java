package com.example.project.controller;

import com.example.project.controller.service.UserProfileService;
import com.example.project.model.dto.UserDTO;
import com.example.project.model.entities.User;
import com.example.project.model.mappers.UserAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserProfileService userProfileService;
    private final UserAssembler userAssembler;

    public UserController(UserService userService, UserProfileService userProfileService, UserAssembler userAssembler) {
        this.userService = userService;
        this.userProfileService = userProfileService;
        this.userAssembler = userAssembler;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        User user = userService.createUser(createUserDTO.getUsername(), createUserDTO.getPassword(),
                createUserDTO.getEmail());
        UserDTO userDTO = userAssembler.toModel(user);
        return ResponseEntity.created(userDTO.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDTO userDTO = userAssembler.toModel(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        UserDTO userDTO = userAssembler.toModel(user);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO updateUserDTO) {
        User user = userService.updateUser(id, updateUserDTO.getUsername(), updateUserDTO.getPassword(),
                updateUserDTO.getEmail());
        UserDTO userDTO = userAssembler.toModel(user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<UserProfileDTO> createUserProfile(@PathVariable Long userId,
                                                            @Valid @RequestBody CreateUserProfileDTO createUserProfileDTO) {
        UserProfile userProfile = userProfileService.createUserProfile(userId, createUserProfileDTO.getFullName(),
                createUserProfileDTO.getPhoneNumber(), createUserProfileDTO.getAddress());
        UserProfileDTO userProfileDTO = UserProfileAssembler.toModel(userProfile);
        return ResponseEntity.created(userProfileDTO.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(userProfileDTO);
    }

    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long userId) {
        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);
        UserProfileDTO userProfileDTO = UserProfileAssembler.toModel(userProfile);
        return ResponseEntity.ok(userProfileDTO);
    }

    @PutMapping("/{userId}/profile")
    public ResponseEntity<UserProfileDTO> updateUserProfile(@PathVariable Long userId,
                                                            @Valid @RequestBody UpdateUserProfileDTO updateUserProfileDTO) {
        UserProfile userProfile = userProfileService.updateUserProfile(userId, updateUserProfileDTO.getFullName(),
                updateUserProfileDTO.getPhoneNumber(), updateUserProfileDTO.getAddress());
        UserProfileDTO userProfileDTO = UserProfileAssembler.toModel(userProfile);
        return ResponseEntity.ok(userProfileDTO);
    }
}

