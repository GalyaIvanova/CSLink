package com.example.project.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "procedure")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cosmetologist_id")
    private Cosmetologist cosmetologist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cosmetologist getCosmetologist() {
        return cosmetologist;
    }

    public void setCosmetologist(Cosmetologist cosmetologist) {
        this.cosmetologist = cosmetologist;
    }

    // getters and setters
}
