package com.example.infrastructure.repository;

import com.example.application.mapper.ReservationMapper;
import com.example.domain.model.Reservation;
import com.example.domain.repository.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JpaReservationRepository jpaReservationRepository;

    public ReservationRepositoryImpl(JpaReservationRepository jpaReservationRepository) {
        this.jpaReservationRepository = jpaReservationRepository;
    }

    @Override
    public List<Reservation> findAll() { // Implémentation pour GetAllReservationsUseCase
        return jpaReservationRepository.findAll().stream()
                .map(ReservationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reservation> findById(Long id) { // Implémentation pour GetReservationByIdUseCase
        return jpaReservationRepository.findById(id)
                .map(ReservationMapper::toDomain);
    }

    @Override
    public void save(Reservation reservation) { // Implémentation pour AddReservationUseCase et UpdateReservationUseCase
        jpaReservationRepository.save(ReservationMapper.toEntity(reservation));
    }

    @Override
    public void deleteById(Long id) { // Implémentation pour DeleteReservationUseCase
        jpaReservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findByClientId(Long clientId) { // Implémentation pour FindReservationByClientUseCase
        return jpaReservationRepository.findByClientId(clientId).stream()
                .map(ReservationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findBySeanceId(Long seanceId) { // Implémentation pour FindReservationBySeanceUseCase
        return jpaReservationRepository.findBySeanceId(seanceId).stream()
                .map(ReservationMapper::toDomain)
                .collect(Collectors.toList());
    }
}
