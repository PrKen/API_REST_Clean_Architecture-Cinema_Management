package com.example.adapters.controllers;

import com.example.application.dto.SeanceDTO;
import com.example.application.services.SeanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/seances")
@Tag(name = "Session Management", description = "Endpoints for managing cinema sessions")
public class SeanceController {

    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    @Operation(summary = "Get all sessions", description = "Retrieve a list of all cinema sessions.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<List<SeanceDTO>> getAllSeances() {
        return ResponseEntity.ok(seanceService.getAllSeances());
    }

    @PostMapping
    @Operation(summary = "Add a session", description = "Create a new cinema session.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Session created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid session data.")
    })
    public ResponseEntity<SeanceDTO> addSeance(@RequestBody SeanceDTO seanceDTO) {
        return ResponseEntity.status(201).body(seanceService.addSeance(seanceDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a session", description = "Delete a cinema session by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Session deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Session not found.")
    })
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a session by ID", description = "Retrieve details of a cinema session by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Session retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Session not found.")
    })
    public ResponseEntity<SeanceDTO> getSeanceById(@PathVariable Long id) {
        return ResponseEntity.ok(seanceService.getSeanceById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a session", description = "Update the information of an existing session.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Session updated successfully."),
            @ApiResponse(responseCode = "404", description = "Session not found."),
            @ApiResponse(responseCode = "400", description = "Invalid session data.")
    })
    public ResponseEntity<SeanceDTO> updateSeance(@PathVariable Long id, @RequestBody SeanceDTO seanceDTO) {
        return ResponseEntity.ok(seanceService.updateSeance(id, seanceDTO));
    }

    @GetMapping("/date")
    @Operation(summary = "Get sessions by date", description = "Retrieve a list of sessions on a specific date.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No sessions found on the specified date.")
    })
    public ResponseEntity<List<SeanceDTO>> findSeancesByDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(seanceService.findSeancesByDate(date));
    }

    @GetMapping("/time")
    @Operation(summary = "Get sessions by time", description = "Retrieve a list of sessions at a specific time.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No sessions found at the specified time.")
    })
    public ResponseEntity<List<SeanceDTO>> findSeancesByTime(@RequestParam LocalTime time) {
        return ResponseEntity.ok(seanceService.findSeancesByTime(time));
    }

    @GetMapping("/film/{filmId}")
    @Operation(summary = "Get sessions by film", description = "Retrieve a list of sessions for a specific film.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No sessions found for the specified film.")
    })
    public ResponseEntity<List<SeanceDTO>> findSeancesByFilm(@PathVariable Long filmId) {
        return ResponseEntity.ok(seanceService.findSeancesByFilm(filmId));
    }

    @GetMapping("/salle/{salleId}")
    @Operation(summary = "Get sessions by room", description = "Retrieve a list of sessions for a specific room.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No sessions found for the specified room.")
    })
    public ResponseEntity<List<SeanceDTO>> findSeancesBySalle(@PathVariable Long salleId) {
        return ResponseEntity.ok(seanceService.findSeancesBySalle(salleId));
    }
}
