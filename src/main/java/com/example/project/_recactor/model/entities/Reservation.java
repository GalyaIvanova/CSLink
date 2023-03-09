package com.example.project._recactor.model.entities;

import com.example.project.management.reservation.model.datatypes.ds.AppointmentTime;
import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cosmetologist_id")
    private Cosmetologist cosmetologist;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedure_id", nullable = false)
    private Procedure procedure;


    @Embedded
    private AppointmentTime appointmentTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cosmetologist getCosmetologist() {
        return cosmetologist;
    }

    public void setCosmetologist(Cosmetologist cosmetologist) {
        this.cosmetologist = cosmetologist;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
//    public Long getClientId() {
//        return client.getId();
//    }
//
//    public void setClientId(Long client) {
//        this.client.getId() = client;
//    }

    public AppointmentTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(AppointmentTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }
}
