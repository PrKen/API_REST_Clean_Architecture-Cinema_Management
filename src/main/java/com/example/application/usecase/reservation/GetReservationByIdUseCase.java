package com.example.application.usecase.reservation;

import com.example.application.dto.ReservationDTO;
import com.example.application.mapper.ReservationMapper;
import com.example.domain.repository.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class GetReservationByIdUseCase {

    private final ReservationRepository reservationRepository;

    public GetReservationByIdUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDTO execute(Long id) {
        return reservationRepository.findById(id)
                .map(ReservationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));
    }
}
