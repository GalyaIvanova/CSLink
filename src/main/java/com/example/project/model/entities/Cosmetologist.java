package com.example.project.model.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cosmetologist")
public class Cosmetologist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String IBAN;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userProfile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "cosmetologist", cascade = CascadeType.ALL)
    private List<Procedure> procedures;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cosmetologist_client",
            joinColumns = @JoinColumn(name = "cosmetologist_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients;

    @OneToMany(mappedBy = "cosmetologist", cascade = CascadeType.ALL)
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

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // getters and setters
}