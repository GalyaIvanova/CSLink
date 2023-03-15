package com.example.project._recactor.controller.service;

import com.example.project._useless.dto.ReservationDTO;
import com.example.project._recactor.model.entities.Reservation;

import java.util.List;

public interface ReservationService {

    ReservationDTO getReservationById(Long id);

    ReservationDTO createReservation(Reservation reservation);

    ReservationDTO updateReservation(Long id, Reservation reservation);

    void deleteReservation(Long id);

    List<ReservationDTO> getReservationsByClient(Long clientId);

    List<ReservationDTO> getReservationsByCosmetologist(Long cosmetologistId);
    List<ReservationDTO> getAllReservations();
}
