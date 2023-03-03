package com.example.project.controller;

import com.example.project.controller.service.UserProfileService;
import com.example.project.model.dto.UserProfileDTO;
import com.example.project.model.entities.UserProfile;
import com.example.project.model.mappers.UserProfileAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user-profiles")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserProfileAssembler userProfileAssembler;


    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfileById(@PathVariable Long id) {
        UserProfile userProfile=userProfileService.getUserProfileById(id);
        UserProfileDTO userProfileDTO=userProfileAssembler.toDtoModel(userProfile);
        return ResponseEntity.ok().body(userProfileDTO);
    }

    @PostMapping
    public ResponseEntity<UserProfileDTO> createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        UserProfile userProfile=userProfileAssembler.toEntity(userProfileDTO);
        UserProfileDTO savedUserProfile=userProfileService.createUserProfile(userProfile);

        return ResponseEntity.created(URI.create("/user-profiles/" + savedUserProfile.getId()))
                .body(savedUserProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
        UserProfile userProfile=userProfileAssembler.toEntity(userProfileDTO);
        userProfile.setId(id);
        UserProfileDTO updatedUserProfile=userProfileService.updateUserProfile(id,userProfile);
        return ResponseEntity.ok().body(updatedUserProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.noContent().build();
    }
}

