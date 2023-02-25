package com.example.project.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userProfile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @ManyToMany(mappedBy = "clients")
    private Set<Cosmetologist> cosmetologists;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Set<Cosmetologist> getCosmetologists() {
        return cosmetologists;
    }

    public void setCosmetologists(Set<Cosmetologist> cosmetologists) {
        this.cosmetologists = cosmetologists;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    // getters and setters
}