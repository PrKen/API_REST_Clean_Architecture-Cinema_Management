package com.example.infrastructure.repository;

import com.example.infrastructure.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findByNomContainingIgnoreCase(String nom); // Requis pour FindClientByNameUseCase
}
