package com.example.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "seance_id", nullable = false)
    private SeanceEntity seance;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public SeanceEntity getSeance() {
        return seance;
    }

    public void setSeance(SeanceEntity seance) {
        this.seance = seance;
    }
}
