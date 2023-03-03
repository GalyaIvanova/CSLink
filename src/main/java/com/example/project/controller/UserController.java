package com.example.project.controller;

import com.example.project.controller.service.UserProfileService;
import com.example.project.controller.service.UserService;
import com.example.project.model.dto.UserDTO;
import com.example.project.model.dto.UserProfileDTO;
import com.example.project.model.entities.User;
import com.example.project.model.entities.UserProfile;
import com.example.project.model.mappers.UserAssembler;
import com.example.project.model.mappers.UserProfileAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserProfileAssembler userProfileAssembler;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO user=userService.createUser(userDTO);
        return ResponseEntity.ok(user);
        //return ResponseEntity.created(userDTO.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user=userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

//    @GetMapping("/username/{username}")
//    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
//        User user = userService.getUserByUsername(username);
//        UserDTO userDTO = userAssembler.toModel(user);
//        return ResponseEntity.ok(userDTO);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO updateUserDTO) {
        UserDTO user=userService.updateUser(id, updateUserDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<UserProfileDTO> createUserProfile(@PathVariable Long userId,
                                                            @RequestBody UserProfileDTO createUserProfileDTO) {
        UserProfileDTO userProfile=userProfileService.createUserProfile(userProfileAssembler.toEntity(createUserProfileDTO));
        return ResponseEntity.ok(userProfile);
//        return ResponseEntity.created(userProfile.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(userProfileDTO);
    }

    //TODO
//    @GetMapping("/{userId}/profile")
//    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long userId) {
//        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);
//        UserProfileDTO userProfileDTO = UserProfileAssembler.toModel(userProfile);
//        return ResponseEntity.ok(userProfileDTO);
//    }
//
//    @PutMapping("/{userId}/profile")
//    public ResponseEntity<UserProfileDTO> updateUserProfile(@PathVariable Long userId,
//                                                            @Valid @RequestBody UpdateUserProfileDTO updateUserProfileDTO) {
//        UserProfile userProfile = userProfileService.updateUserProfile(userId, updateUserProfileDTO.getFullName(),
//                updateUserProfileDTO.getPhoneNumber(), updateUserProfileDTO.getAddress());
//        UserProfileDTO userProfileDTO = UserProfileAssembler.toModel(userProfile);
//        return ResponseEntity.ok(userProfileDTO);
//    }
}

