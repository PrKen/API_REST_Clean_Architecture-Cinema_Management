package com.example.domain.repository;

import com.example.domain.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    List<Reservation> findAll(); // Requis pour GetAllReservationsUseCase
    Optional<Reservation> findById(Long id); // Requis pour GetReservationByIdUseCase
    void save(Reservation reservation); // Requis pour AddReservationUseCase et UpdateReservationUseCase
    void deleteById(Long id); // Requis pour DeleteReservationUseCase
    List<Reservation> findByClientId(Long clientId); // Requis pour FindReservationByClientUseCase
    List<Reservation> findBySeanceId(Long seanceId); // Requis pour FindReservationBySeanceUseCase
}
