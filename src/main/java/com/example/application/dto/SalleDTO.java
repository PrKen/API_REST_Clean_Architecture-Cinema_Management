package com.example.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representation of a cinema room.")
public class SalleDTO {

    @Schema(description = "Unique identifier of the room.", example = "1")
    private Long id;

    @Schema(description = "Name of the room.", example = "Salle 1")
    private String nom;

    @Schema(description = "Capacity of the room.", example = "100")
    private int capacite;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }
}
