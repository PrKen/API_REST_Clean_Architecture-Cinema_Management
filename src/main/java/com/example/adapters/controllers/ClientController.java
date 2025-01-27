package com.example.adapters.controllers;

import com.example.application.dto.ClientDTO;
import com.example.application.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client Management", description = "Endpoints for managing clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary = "Get all clients", description = "Retrieve a list of all clients.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clients retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID", description = "Retrieve a client by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Client not found."),
            @ApiResponse(responseCode = "400", description = "Invalid ID format.")
    })
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    @Operation(summary = "Add a client", description = "Create a new client.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Client created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid client data.")
    })
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(201).body(clientService.addClient(clientDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client", description = "Delete a client by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Client not found.")
    })
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @Operation(summary = "Search clients by name", description = "Retrieve a list of clients by their name.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clients retrieved successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid query parameters.")
    })
    public ResponseEntity<List<ClientDTO>> getClientsByName(@RequestParam String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a client", description = "Update the information of an existing client.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client updated successfully."),
            @ApiResponse(responseCode = "404", description = "Client not found."),
            @ApiResponse(responseCode = "400", description = "Invalid client data.")
    })
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(id, clientDTO));
    }
}
