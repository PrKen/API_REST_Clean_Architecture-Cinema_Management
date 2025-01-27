package com.example.infrastructure.repository;

import com.example.infrastructure.entity.SeanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface JpaSeanceRepository extends JpaRepository<SeanceEntity, Long> {
    List<SeanceEntity> findByDate(LocalDate date); // Requis pour FindSeanceByDateUseCase
    List<SeanceEntity> findByHeure(LocalTime heure); // Requis pour FindSeanceByTimeUseCase
    List<SeanceEntity> findByFilmId(Long filmId); // Requis pour FindSeanceByFilmUseCase
    List<SeanceEntity> findBySalleId(Long salleId); // Requis pour FindSeanceBySalleUseCase
}
