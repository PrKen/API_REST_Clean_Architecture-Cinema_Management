package com.example.application.mapper;

import com.example.infrastructure.entity.SalleEntity;
import com.example.application.dto.SalleDTO;
import com.example.domain.model.Salle;

public class SalleMapper {

    public static SalleDTO toDto(Salle salle) {
        SalleDTO dto = new SalleDTO();
        dto.setId(salle.getId());
        dto.setNom(salle.getNom());
        dto.setCapacite(salle.getCapacite());
        return dto;
    }

    public static Salle toDomain(SalleDTO salleDTO) {
        Salle salle = new Salle();
        salle.setId(salleDTO.getId());
        salle.setNom(salleDTO.getNom());
        salle.setCapacite(salleDTO.getCapacite());
        return salle;
    }

    public static SalleEntity toEntity(Salle salle) {
        SalleEntity entity = new SalleEntity();
        entity.setId(salle.getId());
        entity.setNom(salle.getNom());
        entity.setCapacite(salle.getCapacite());
        return entity;
    }

    public static Salle toDomain(SalleEntity entity) {
        Salle salle = new Salle();
        salle.setId(entity.getId());
        salle.setNom(entity.getNom());
        salle.setCapacite(entity.getCapacite());
        return salle;
    }
}
