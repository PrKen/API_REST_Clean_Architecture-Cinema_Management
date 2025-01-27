package com.example.application.usecase.reservation;

import com.example.application.dto.ReservationDTO;
import com.example.application.mapper.ReservationMapper;
import com.example.domain.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindReservationBySeanceUseCase {

    private final ReservationRepository reservationRepository;

    public FindReservationBySeanceUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDTO> execute(Long seanceId) {
        return reservationRepository.findBySeanceId(seanceId).stream()
                .map(ReservationMapper::toDto)
                .collect(Collectors.toList());
    }
}
