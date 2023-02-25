package com.example.project.model.entities;

import com.example.project.model.data.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Role role;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Embedded
    private Phone phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // getters and setters
}

