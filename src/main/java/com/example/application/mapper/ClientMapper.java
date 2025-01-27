package com.example.application.mapper;

import com.example.application.dto.ClientDTO;
import com.example.domain.model.Client;
import com.example.infrastructure.entity.ClientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {

    // Conversion d'un Client (domain) vers ClientDTO (application)
    public static ClientDTO toDto(Client client) {
        if (client == null) {
            return null;
        }
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        return dto;
    }

    // Conversion d'une liste de Client (domain) vers une liste de ClientDTO (application)
    public static List<ClientDTO> toDtoList(List<Client> clients) {
        if (clients == null || clients.isEmpty()) {
            return List.of();
        }
        return clients.stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    // Conversion d'un ClientDTO (application) vers Client (domain)
    public static Client toDomain(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return client;
    }

    // Conversion d'un ClientEntity (infrastructure) vers Client (domain)
    public static Client toDomain(ClientEntity entity) {
        if (entity == null) {
            return null;
        }
        Client client = new Client();
        client.setId(entity.getId());
        client.setNom(entity.getNom());
        client.setEmail(entity.getEmail());
        return client;
    }

    // Conversion d'un Client (domain) vers ClientEntity (infrastructure)
    public static ClientEntity toEntity(Client client) {
        if (client == null) {
            return null;
        }
        ClientEntity entity = new ClientEntity();
        entity.setId(client.getId());
        entity.setNom(client.getNom());
        entity.setEmail(client.getEmail());
        return entity;
    }
}
