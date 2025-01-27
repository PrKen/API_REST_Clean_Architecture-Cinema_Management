package com.example.application.mapper;

import com.example.application.dto.ReservationDTO;
import com.example.domain.model.Client;
import com.example.domain.model.Reservation;
import com.example.domain.model.Seance;
import com.example.infrastructure.entity.ClientEntity;
import com.example.infrastructure.entity.ReservationEntity;
import com.example.infrastructure.entity.SeanceEntity;

public class ReservationMapper {

    // Conversion d'un Reservation (domain) vers ReservationDTO (application)
    public static ReservationDTO toDto(Reservation reservation) {
        if (reservation == null) return null;

        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setClientId(reservation.getClient() != null ? reservation.getClient().getId() : null);
        dto.setSeanceId(reservation.getSeance() != null ? reservation.getSeance().getId() : null);
        return dto;
    }

    // Conversion d'un ReservationDTO (application) vers Reservation (domain)
    public static Reservation toDomain(ReservationDTO dto) {
        if (dto == null) return null;

        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());

        Client client = new Client();
        client.setId(dto.getClientId());
        reservation.setClient(client);

        Seance seance = new Seance();
        seance.setId(dto.getSeanceId());
        reservation.setSeance(seance);

        return reservation;
    }

    // Conversion d'un ReservationEntity (infrastructure) vers Reservation (domain)
    public static Reservation toDomain(ReservationEntity entity) {
        if (entity == null) return null;

        Reservation reservation = new Reservation();
        reservation.setId(entity.getId());

        Client client = new Client();
        client.setId(entity.getClient() != null ? entity.getClient().getId() : null);
        reservation.setClient(client);

        Seance seance = new Seance();
        seance.setId(entity.getSeance() != null ? entity.getSeance().getId() : null);
        reservation.setSeance(seance);

        return reservation;
    }

    // Conversion d'un Reservation (domain) vers ReservationEntity (infrastructure)
    public static ReservationEntity toEntity(Reservation reservation) {
        if (reservation == null) return null;

        ReservationEntity entity = new ReservationEntity();
        entity.setId(reservation.getId());

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(reservation.getClient() != null ? reservation.getClient().getId() : null);
        entity.setClient(clientEntity);

        SeanceEntity seanceEntity = new SeanceEntity();
        seanceEntity.setId(reservation.getSeance() != null ? reservation.getSeance().getId() : null);
        entity.setSeance(seanceEntity);

        return entity;
    }
}
