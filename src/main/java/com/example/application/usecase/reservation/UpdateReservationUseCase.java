package com.example.application.usecase.reservation;

import com.example.application.dto.ReservationDTO;
import com.example.application.mapper.ReservationMapper;
import com.example.domain.model.Client;
import com.example.domain.model.Reservation;
import com.example.domain.model.Seance;
import com.example.domain.repository.ClientRepository;
import com.example.domain.repository.ReservationRepository;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateReservationUseCase {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final SeanceRepository seanceRepository;

    public UpdateReservationUseCase(ReservationRepository reservationRepository,
                                    ClientRepository clientRepository,
                                    SeanceRepository seanceRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.seanceRepository = seanceRepository;
    }

    public ReservationDTO execute(Long id, ReservationDTO reservationDTO) {
        // Vérification de la réservation
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));

        // Récupération des relations
        Client client = clientRepository.findById(reservationDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + reservationDTO.getClientId()));
        Seance seance = seanceRepository.findById(reservationDTO.getSeanceId())
                .orElseThrow(() -> new RuntimeException("Seance not found with id: " + reservationDTO.getSeanceId()));

        // Mise à jour des relations
        existingReservation.setClient(client);
        existingReservation.setSeance(seance);

        reservationRepository.save(existingReservation);

        return ReservationMapper.toDto(existingReservation);
    }
}
