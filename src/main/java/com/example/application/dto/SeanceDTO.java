package com.example.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;

@Schema(description = "Representation of a cinema session.")
public class SeanceDTO {

    @Schema(description = "Unique identifier of the session.", example = "1")
    private Long id;

    @Schema(description = "Date of the session.", example = "2023-12-31")
    private LocalDate date;

    @Schema(description = "Time of the session.", example = "18:30")
    private LocalTime heure;

    @Schema(description = "Film ID associated with the session.", example = "1")
    private Long filmId;

    @Schema(description = "Room ID where the session takes place.", example = "2")
    private Long salleId;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public Long getFilmId() { return filmId; }
    public void setFilmId(Long filmId) { this.filmId = filmId; }

    public Long getSalleId() { return salleId; }
    public void setSalleId(Long salleId) { this.salleId = salleId; }
}
