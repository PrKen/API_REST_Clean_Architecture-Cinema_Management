package com.example.application.services;

import com.example.adapters.events.ReservationEvent;
//import com.example.adapters.messaging.KafkaProducerService;
import com.example.application.dto.ReservationDTO;
import com.example.application.usecase.reservation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final GetAllReservationsUseCase getAllReservationsUseCase;
    private final GetReservationByIdUseCase getReservationByIdUseCase;
    private final AddReservationUseCase addReservationUseCase;
    private final DeleteReservationUseCase deleteReservationUseCase;
    private final FindReservationByClientUseCase findReservationByClientUseCase;
    private final FindReservationBySeanceUseCase findReservationBySeanceUseCase;
    private final UpdateReservationUseCase updateReservationUseCase;
    //private final KafkaProducerService kafkaProducerService;

    public ReservationService(GetAllReservationsUseCase getAllReservationsUseCase,
                              GetReservationByIdUseCase getReservationByIdUseCase,
                              AddReservationUseCase addReservationUseCase,
                              DeleteReservationUseCase deleteReservationUseCase,
                              FindReservationByClientUseCase findReservationByClientUseCase,
                              FindReservationBySeanceUseCase findReservationBySeanceUseCase,
                              UpdateReservationUseCase updateReservationUseCase
                              /*KafkaProducerService kafkaProducerService*/) {
        this.getAllReservationsUseCase = getAllReservationsUseCase;
        this.getReservationByIdUseCase = getReservationByIdUseCase;
        this.addReservationUseCase = addReservationUseCase;
        this.deleteReservationUseCase = deleteReservationUseCase;
        this.findReservationByClientUseCase = findReservationByClientUseCase;
        this.findReservationBySeanceUseCase = findReservationBySeanceUseCase;
        this.updateReservationUseCase = updateReservationUseCase;
        //this.kafkaProducerService = kafkaProducerService;
    }

    public List<ReservationDTO> getAllReservations() {
        return getAllReservationsUseCase.execute();
    }

    public ReservationDTO getReservationById(Long id) {
        return getReservationByIdUseCase.execute(id);
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        // Call the use case to create a reservation
        ReservationDTO createdReservation = addReservationUseCase.execute(reservationDTO);

        /* Create and send a Kafka event
        ReservationEvent event = new ReservationEvent(
                createdReservation.getId(),
                "CREATED"
        );
        kafkaProducerService.sendReservationEvent(event); */

        return createdReservation;
    }

    public void deleteReservation(Long id) {
        deleteReservationUseCase.execute(id);

        /* Create and send a Kafka event for deletion
        ReservationEvent event = new ReservationEvent(id, "DELETED");
        kafkaProducerService.sendReservationEvent(event); */
    }

    public List<ReservationDTO> findByClient(Long clientId) {
        return findReservationByClientUseCase.execute(clientId);
    }

    public List<ReservationDTO> findBySeance(Long seanceId) {
        return findReservationBySeanceUseCase.execute(seanceId);
    }

    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        // Call the use case to update the reservation
        ReservationDTO updatedReservation = updateReservationUseCase.execute(id, reservationDTO);

        /* Create and send a Kafka event for the update
        ReservationEvent event = new ReservationEvent(
                updatedReservation.getId(),
                "UPDATED"
        );
        kafkaProducerService.sendReservationEvent(event); */

        return updatedReservation;
    }
}
