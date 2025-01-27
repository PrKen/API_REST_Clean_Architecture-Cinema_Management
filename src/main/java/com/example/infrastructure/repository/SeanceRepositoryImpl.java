package com.example.infrastructure.repository;

import com.example.application.mapper.SeanceMapper;
import com.example.domain.model.Seance;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SeanceRepositoryImpl implements SeanceRepository {

    private final JpaSeanceRepository jpaSeanceRepository;

    public SeanceRepositoryImpl(JpaSeanceRepository jpaSeanceRepository) {
        this.jpaSeanceRepository = jpaSeanceRepository;
    }

    @Override
    public List<Seance> findAll() { // Implémentation pour GetAllSeancesUseCase
        return jpaSeanceRepository.findAll().stream()
                .map(SeanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Seance> findById(Long id) { // Implémentation pour GetSeanceByIdUseCase
        return jpaSeanceRepository.findById(id)
                .map(SeanceMapper::toDomain);
    }

    @Override
    public void save(Seance seance) { // Implémentation pour AddSeanceUseCase et UpdateSeanceUseCase
        jpaSeanceRepository.save(SeanceMapper.toEntity(seance));
    }

    @Override
    public void deleteById(Long id) { // Implémentation pour DeleteSeanceUseCase
        jpaSeanceRepository.deleteById(id);
    }

    @Override
    public List<Seance> findByDate(LocalDate date) { // Implémentation pour FindSeanceByDateUseCase
        return jpaSeanceRepository.findByDate(date).stream()
                .map(SeanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Seance> findByHeure(LocalTime heure) { // Implémentation pour FindSeanceByTimeUseCase
        return jpaSeanceRepository.findByHeure(heure).stream()
                .map(SeanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Seance> findByFilmId(Long filmId) { // Implémentation pour FindSeanceByFilmUseCase
        return jpaSeanceRepository.findByFilmId(filmId).stream()
                .map(SeanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Seance> findBySalleId(Long salleId) { // Implémentation pour FindSeanceBySalleUseCase
        return jpaSeanceRepository.findBySalleId(salleId).stream()
                .map(SeanceMapper::toDomain)
                .collect(Collectors.toList());
    }
}
