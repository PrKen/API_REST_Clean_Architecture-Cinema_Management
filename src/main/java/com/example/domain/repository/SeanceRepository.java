package com.example.domain.repository;

import com.example.domain.model.Seance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface SeanceRepository {
    List<Seance> findAll(); // Requis pour GetAllSeancesUseCase
    Optional<Seance> findById(Long id); // Requis pour GetSeanceByIdUseCase
    void save(Seance seance); // Requis pour AddSeanceUseCase et UpdateSeanceUseCase
    void deleteById(Long id); // Requis pour DeleteSeanceUseCase
    List<Seance> findByDate(LocalDate date); // Requis pour FindSeanceByDateUseCase
    List<Seance> findByHeure(LocalTime heure); // Requis pour FindSeanceByTimeUseCase
    List<Seance> findByFilmId(Long filmId); // Requis pour FindSeanceByFilmUseCase
    List<Seance> findBySalleId(Long salleId); // Requis pour FindSeanceBySalleUseCase
}
