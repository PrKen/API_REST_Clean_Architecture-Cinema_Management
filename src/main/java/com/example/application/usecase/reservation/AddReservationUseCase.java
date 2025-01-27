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
public class AddReservationUseCase {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final SeanceRepository seanceRepository;

    public AddReservationUseCase(ReservationRepository reservationRepository,
                                 ClientRepository clientRepository,
                                 SeanceRepository seanceRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.seanceRepository = seanceRepository;
    }

    public ReservationDTO execute(ReservationDTO reservationDTO) {
        // Récupération du client
        Client client = clientRepository.findById(reservationDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + reservationDTO.getClientId()));

        // Récupération de la séance
        Seance seance = seanceRepository.findById(reservationDTO.getSeanceId())
                .orElseThrow(() -> new RuntimeException("Seance not found with id: " + reservationDTO.getSeanceId()));

        // Création de la réservation
        Reservation reservation = ReservationMapper.toDomain(reservationDTO);
        reservation.setClient(client);
        reservation.setSeance(seance);

        reservationRepository.save(reservation);

        return ReservationMapper.toDto(reservation);
    }
}
