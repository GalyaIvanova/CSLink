package com.example.project.management.schedule.model.entity;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;

import com.example.project.management.schedule.model.ds.WorkingHours;
import com.example.project._recactor.model.entities.Cosmetologist;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"workingHours"}))
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private WorkingHours workingHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cosmetologist_id")
    private Cosmetologist cosmetologist;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Add this field to store the last time the task was run
    private LocalDateTime lastTaskRun;

    public Availability() {
        this.createdAt = LocalDateTime.now();
        this.lastTaskRun = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Add a method with the @Scheduled annotation to define the scheduled task
    @Scheduled(fixedRate = 360000*24) // Runs every day
    public void scheduledTask() {
        System.out.println("Running scheduled task for entity with ID " + id);
        // TODO: Add your task logic here
        if (workingHours.getDay().isBefore(LocalDateTime.now().toLocalDate()) ){
           // entityManager.remove(this);
        }
        lastTaskRun = LocalDateTime.now();
    }
}