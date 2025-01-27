package com.example.application.usecase.reservation;

import com.example.domain.repository.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteReservationUseCase {

    private final ReservationRepository reservationRepository;

    public DeleteReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void execute(Long id) {
        if (!reservationRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Reservation not found with id: " + id);
        }
        reservationRepository.deleteById(id);
    }
}
