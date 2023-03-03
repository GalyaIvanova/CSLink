package com.example.project.model.entities;


import com.example.project.model.data.ds.WorkingHours;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="cosmetologist")
public class Cosmetologist {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private String IBAN;

    @Embedded
    private WorkingHours availability;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userProfile_id", referencedColumnName="id")
    private UserProfile userProfile;

    @JsonIgnore
    @OneToMany(mappedBy="cosmetologists", cascade=CascadeType.ALL)
    private List<Procedure> procedures;

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="cosmetologist_client",
            joinColumns=@JoinColumn(name="cosmetologist_id"),
            inverseJoinColumns=@JoinColumn(name="client_id"))
    private List<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy="cosmetologist", cascade=CascadeType.ALL)
    private List<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN=IBAN;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile=userProfile;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures=procedures;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients=clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void removeClient(Long clientId) {
        this.clients.removeIf(c -> Objects.equals(clientId, c.getId()));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions=transactions;
    }

    public String getPhoneNumber() {
        return this.userProfile.getPhone().getNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.userProfile.getPhone().setNumber(phoneNumber);
    }

    public void addProcedure(Procedure procedure) {
        this.procedures.add(procedure);
    }

    public void removeProcedure(Long procedureId) {
        this.procedures.removeIf(p -> Objects.equals(p.getId(), procedureId));
    }

    public WorkingHours getAvailability() {
        return availability;
    }

    public void setAvailability(WorkingHours availability) {
        this.availability=availability;
    }
}