package com.example.project.management.reservation.controller.service;

import java.util.List;

import com.example.project._useless.dto.ReservationDTO;
import com.example.project.management.reservation.model.entity.Reservation;

public interface ReservationService {

    ReservationDTO getReservationById(Long id);

    ReservationDTO createReservation(Reservation reservation);

    ReservationDTO updateReservation(Long id, Reservation reservation);

    void deleteReservation(Long id);

    List<ReservationDTO> getReservationsByClient(Long clientId);

    List<ReservationDTO> getReservationsByCosmetologist(Long cosmetologistId);

    List<ReservationDTO> getAllReservations();
}
