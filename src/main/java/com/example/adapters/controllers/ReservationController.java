package com.example.adapters.controllers;

import com.example.application.dto.ReservationDTO;
import com.example.application.services.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservation Management", description = "Endpoints for managing reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @Operation(summary = "Get all reservations", description = "Retrieve a list of all reservations.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservations retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get reservation by ID", description = "Retrieve a reservation by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Reservation not found."),
            @ApiResponse(responseCode = "400", description = "Invalid ID format.")
    })
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @PostMapping
    @Operation(summary = "Add a reservation", description = "Create a new reservation.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reservation created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid reservation data.")
    })
    public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.status(201).body(reservationService.addReservation(reservationDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a reservation", description = "Update the information of an existing reservation.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation updated successfully."),
            @ApiResponse(responseCode = "404", description = "Reservation not found."),
            @ApiResponse(responseCode = "400", description = "Invalid reservation data.")
    })
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservationDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a reservation", description = "Delete a reservation by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Reservation deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Reservation not found.")
    })
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Get reservations by client", description = "Retrieve reservations for a specific client.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservations retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No reservations found for the client.")
    })
    public ResponseEntity<List<ReservationDTO>> getReservationsByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(reservationService.findByClient(clientId));
    }

    @GetMapping("/seance/{seanceId}")
    @Operation(summary = "Get reservations by session", description = "Retrieve reservations for a specific session.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservations retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No reservations found for the session.")
    })
    public ResponseEntity<List<ReservationDTO>> getReservationsBySeance(@PathVariable Long seanceId) {
        return ResponseEntity.ok(reservationService.findBySeance(seanceId));
    }
}
