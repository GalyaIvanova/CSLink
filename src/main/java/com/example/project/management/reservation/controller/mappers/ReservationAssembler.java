package com.example.project.management.reservation.controller.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project._useless.dto.ReservationDTO;
import com.example.project.cosmetologist.controller.service.CosmetologistService;
import com.example.project.customer.controller.service.CustomerService;
import com.example.project.management.reservation.model.entity.Reservation;

@Component
public class ReservationAssembler {

    @Autowired
    private CustomerService clientService;
    @Autowired
    private CosmetologistService cosmetologisttService;

    public ReservationDTO toReservationDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setAppointmentTime(reservation.getAppointmentTime());
        reservationDTO.setClientId(reservation.getClient().getId());
        reservationDTO.setCosmetologistId(reservation.getCosmetologist().getId());
        reservationDTO.setProcedure(reservation.getProcedure());
        return reservationDTO;
    }

    public Reservation toReservationEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setAppointmentTime(reservationDTO.getAppointmentTime());
        reservation.setClient(clientService.getClientById(reservationDTO.getClientId()));
        reservation.setCosmetologist(cosmetologisttService.getCosmetologistById(reservationDTO.getCosmetologistId()));
        reservation.setProcedure(reservationDTO.getProcedure());
        return reservation;
    }


    public List<ReservationDTO> toReservationDTOList(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::toReservationDTO)
                .collect(Collectors.toList());
    }

    public List<Reservation> toReservationEntityList(List<ReservationDTO> reservationDTOs) {
        return reservationDTOs.stream()
                .map(this::toReservationEntity)
                .collect(Collectors.toList());
    }
}

