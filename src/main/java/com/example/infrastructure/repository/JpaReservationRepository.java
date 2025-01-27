package com.example.infrastructure.repository;

import com.example.infrastructure.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByClientId(Long clientId); // Requis pour FindReservationByClientUseCase
    List<ReservationEntity> findBySeanceId(Long seanceId); // Requis pour FindReservationBySeanceUseCase
}
