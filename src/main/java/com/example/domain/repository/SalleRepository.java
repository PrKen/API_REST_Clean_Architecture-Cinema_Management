package com.example.domain.repository;

import com.example.domain.model.Salle;

import java.util.List;
import java.util.Optional;

public interface SalleRepository {
    List<Salle> findAll(); // Requis pour GetAllSallesUseCase
    Optional<Salle> findById(Long id); // Requis pour GetSalleByIdUseCase
    void save(Salle salle); // Requis pour AddSalleUseCase et UpdateSalleUseCase
    void deleteById(Long id); // Requis pour DeleteSalleUseCase
}
