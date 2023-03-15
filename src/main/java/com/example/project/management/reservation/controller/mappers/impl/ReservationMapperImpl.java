package com.example.project.management.reservation.controller.mappers.impl;

import com.example.project._useless.dto.ReservationDTO;
import com.example.project.management.reservation.controller.mappers.ReservationMapper;
import com.example.project.management.reservation.model.entity.Reservation;

public class ReservationMapperImpl implements ReservationMapper {
    @Override
    public ReservationDTO toDTO(Reservation entity) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(entity.getId());
        reservationDTO.setAppointmentTime(entity.getAppointmentTime());
        reservationDTO.setClientId(entity.getClient().getId());
        reservationDTO.setProcedure(entity.getProcedure());
        reservationDTO.setCosmetologistId(entity.getCosmetologist().getId());
        return reservationDTO;
    }
}
