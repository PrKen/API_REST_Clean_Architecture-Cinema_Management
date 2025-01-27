package com.example.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representation of a client.")
public class ClientDTO {

    @Schema(description = "Unique identifier of the client.", example = "1")
    private Long id;

    @Schema(description = "Name of the client.", example = "John Doe")
    private String nom;

    @Schema(description = "Email of the client.", example = "john.doe@example.com")
    private String email;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
