package com.example.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Seance {
    private Long id;
    private LocalDate date;
    private LocalTime heure;
    private Film film;
    private Salle salle;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public Salle getSalle() { return salle; }
    public void setSalle(Salle salle) { this.salle = salle; }
}
