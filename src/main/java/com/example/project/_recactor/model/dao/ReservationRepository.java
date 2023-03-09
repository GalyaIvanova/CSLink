package com.example.project._recactor.model.dao;

import com.example.project._recactor.model.entities.Cosmetologist;
import com.example.project._recactor.model.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByCosmetologist(Cosmetologist cosmetologist);

    List<Reservation> findByClientId(Long clientId);

    List<Reservation> findByCosmetologistId(Long cosmetologistId);
}
