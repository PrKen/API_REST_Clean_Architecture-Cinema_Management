package com.example.infrastructure.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "seances")
public class SeanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private FilmEntity film;

    @ManyToOne
    @JoinColumn(name = "salle_id", nullable = false)
    private SalleEntity salle;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public FilmEntity getFilm() { return film; }
    public void setFilm(FilmEntity film) { this.film = film; }

    public SalleEntity getSalle() { return salle; }
    public void setSalle(SalleEntity salle) { this.salle = salle; }
}
