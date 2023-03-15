package com.example.project.management.reservation.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.cosmetologist.model.entity.Cosmetologist;
import com.example.project.management.reservation.model.entity.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {

    List<Reservation> findByCosmetologist(Cosmetologist cosmetologist);

    List<Reservation> findByClientId(Long clientId);

    List<Reservation> findByCosmetologistId(Long cosmetologistId);
}
