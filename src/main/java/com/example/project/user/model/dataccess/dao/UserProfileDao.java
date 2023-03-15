package com.example.project.user.model.dataccess.dao;

import com.example.project.user.model.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDao extends JpaRepository<UserProfile, Long> {
}

