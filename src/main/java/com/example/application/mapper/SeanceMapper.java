package com.example.application.mapper;

import com.example.infrastructure.entity.FilmEntity;
import com.example.infrastructure.entity.SalleEntity;
import com.example.infrastructure.entity.SeanceEntity;
import com.example.application.dto.SeanceDTO;
import com.example.domain.model.Film;
import com.example.domain.model.Salle;
import com.example.domain.model.Seance;

public class SeanceMapper {

    public static SeanceDTO toDto(Seance seance) {
        SeanceDTO dto = new SeanceDTO();
        dto.setId(seance.getId());
        dto.setDate(seance.getDate());
        dto.setHeure(seance.getHeure());
        dto.setFilmId(seance.getFilm().getId());
        dto.setSalleId(seance.getSalle().getId());
        return dto;
    }

    public static Seance toDomain(SeanceDTO dto) {
        Seance seance = new Seance();
        seance.setId(dto.getId());
        seance.setDate(dto.getDate());
        seance.setHeure(dto.getHeure());

        Film film = new Film();
        film.setId(dto.getFilmId());
        seance.setFilm(film);

        Salle salle = new Salle();
        salle.setId(dto.getSalleId());
        seance.setSalle(salle);

        return seance;
    }

    public static SeanceEntity toEntity(Seance seance) {
        SeanceEntity entity = new SeanceEntity();
        entity.setId(seance.getId());
        entity.setDate(seance.getDate());
        entity.setHeure(seance.getHeure());

        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(seance.getFilm().getId());
        entity.setFilm(filmEntity);

        SalleEntity salleEntity = new SalleEntity();
        salleEntity.setId(seance.getSalle().getId());
        entity.setSalle(salleEntity);

        return entity;
    }

    public static Seance toDomain(SeanceEntity entity) {
        Seance seance = new Seance();
        seance.setId(entity.getId());
        seance.setDate(entity.getDate());
        seance.setHeure(entity.getHeure());

        Film film = new Film();
        film.setId(entity.getFilm().getId());
        seance.setFilm(film);

        Salle salle = new Salle();
        salle.setId(entity.getSalle().getId());
        seance.setSalle(salle);

        return seance;
    }
}
