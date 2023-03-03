package com.example.project.controller.service.implementations;

import com.example.project.controller.service.ReservationService;
import com.example.project.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project.model.dao.ReservationRepository;
import com.example.project.model.dto.ReservationDTO;
import com.example.project.model.entities.Reservation;

import com.example.project.model.mappers.ReservationAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationAssembler reservationAssembler;
    @Autowired
    private  ReservationRepository reservationRepository;

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation=reservationRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException("Reservation", id));
        return reservationAssembler.toReservationDTO(reservation);

    }

    @Override
    public ReservationDTO createReservation(Reservation reservation) {
        return reservationAssembler.toReservationDTO(reservationRepository.save(reservation));
    }

    @Override
    public ReservationDTO updateReservation(Long id, Reservation reservation) {
        return null;
    }

//    @Override
//    public Reservation createReservation(Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }

//    @Override
//    public Reservation updateReservation(Long id, Reservation reservation) {
//        Reservation existingReservation = reservationRepository.findById(id)
//                .orElseThrow(() -> new CustomResourceNotFoundException ("Reservation", id));
//
//        existingReservation.setClient(reservation.getClient());
//        existingReservation.setCosmetologist(reservation.getCosmetologist());
//        existingReservation.setAppointmentTime(reservation.getAppointmentTime());
//
//        return reservationRepository.save(existingReservation);
//    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new CustomResourceNotFoundException ("Reservation", id));
        reservationRepository.delete(reservation);
    }

    @Override
    public List<ReservationDTO> getReservationsByClient(Long clientId) {
        List<Reservation> reservations = reservationRepository.findByClientId(clientId);
        return reservationAssembler.toReservationDTOList(reservations);

    }

    @Override
    public List<ReservationDTO> getReservationsByCosmetologist(Long cosmetologistId) {
        List<Reservation> reservations = reservationRepository.findByCosmetologistId(cosmetologistId);
        return reservationAssembler.toReservationDTOList(reservations);
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations=reservationRepository.findAll();
        return reservationAssembler.toReservationDTOList(reservations);

    }
}
