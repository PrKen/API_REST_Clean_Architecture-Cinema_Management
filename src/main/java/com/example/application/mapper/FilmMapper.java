package com.example.application.mapper;

import com.example.application.dto.FilmDTO;
import com.example.domain.model.Film;
import com.example.infrastructure.entity.FilmEntity;

public class FilmMapper {

    public static FilmDTO toDto(Film film) {
        FilmDTO dto = new FilmDTO();
        dto.setId(film.getId());
        dto.setTitre(film.getTitre());
        dto.setCategorie(film.getCategorie());
        dto.setDescription(film.getDescription());
        return dto;
    }

    public static Film toDomain(FilmDTO dto) {
        Film film = new Film();
        film.setId(dto.getId());
        film.setTitre(dto.getTitre());
        film.setCategorie(dto.getCategorie());
        film.setDescription(dto.getDescription());
        return film;
    }

    public static Film toDomain(FilmEntity entity) {
        Film film = new Film();
        film.setId(entity.getId());
        film.setTitre(entity.getTitre());
        film.setCategorie(entity.getCategorie());
        film.setDescription(entity.getDescription());
        return film;
    }

    public static FilmEntity toEntity(Film film) {
        FilmEntity entity = new FilmEntity();
        entity.setId(film.getId());
        entity.setTitre(film.getTitre());
        entity.setCategorie(film.getCategorie());
        entity.setDescription(film.getDescription());
        return entity;
    }
}
