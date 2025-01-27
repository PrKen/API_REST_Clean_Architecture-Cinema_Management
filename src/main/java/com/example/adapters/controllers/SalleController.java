package com.example.adapters.controllers;

import com.example.application.dto.SalleDTO;
import com.example.application.services.SalleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
@Tag(name = "Room Management", description = "Endpoints for managing rooms")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    @Operation(summary = "Get all rooms", description = "Retrieve a list of all rooms.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Rooms retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<List<SalleDTO>> getAllSalles() {
        return ResponseEntity.ok(salleService.getAllSalles());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a room by ID", description = "Retrieve details of a room by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Room not found.")
    })
    public ResponseEntity<SalleDTO> getSalleById(@PathVariable Long id) {
        return ResponseEntity.ok(salleService.getSalleById(id));
    }

    @PostMapping
    @Operation(summary = "Add a room", description = "Create a new room.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Room created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid room data.")
    })
    public ResponseEntity<SalleDTO> addSalle(@RequestBody SalleDTO salleDTO) {
        return ResponseEntity.status(201).body(salleService.addSalle(salleDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a room", description = "Update the information of an existing room.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room updated successfully."),
            @ApiResponse(responseCode = "404", description = "Room not found."),
            @ApiResponse(responseCode = "400", description = "Invalid room data.")
    })
    public ResponseEntity<SalleDTO> updateSalle(@PathVariable Long id, @RequestBody SalleDTO salleDTO) {
        return ResponseEntity.ok(salleService.updateSalle(id, salleDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a room", description = "Delete a room by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Room deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Room not found.")
    })
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return ResponseEntity.noContent().build();
    }
}
