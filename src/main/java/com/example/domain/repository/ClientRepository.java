package com.example.domain.repository;

import com.example.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> findAll();
    Optional<Client> findById(Long id); // Requis pour GetClientByIdUseCase
    void save(Client client);
    void deleteById(Long id);
    List<Client> findByNomContaining(String nom); // Requis pour FindClientByNameUseCase
}
