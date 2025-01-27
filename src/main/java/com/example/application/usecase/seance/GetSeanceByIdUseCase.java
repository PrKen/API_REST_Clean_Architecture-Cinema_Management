package com.example.application.usecase.seance;

import com.example.application.dto.SeanceDTO;
import com.example.application.mapper.SeanceMapper;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

@Component
public class GetSeanceByIdUseCase {

    private final SeanceRepository seanceRepository;

    public GetSeanceByIdUseCase(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public SeanceDTO execute(Long id) {
        return seanceRepository.findById(id)
                .map(SeanceMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Seance not found with ID: " + id));
    }
}
