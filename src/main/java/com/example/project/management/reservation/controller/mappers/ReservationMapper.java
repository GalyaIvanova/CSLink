package com.example.project.management.reservation.controller.mappers;

import org.springframework.stereotype.Component;

import com.example.project._useless.dto.ReservationDTO;
import com.example.project.management.reservation.model.entity.Reservation;

@Component
public interface ReservationMapper {
    ReservationDTO toDTO(Reservation entity);
}
