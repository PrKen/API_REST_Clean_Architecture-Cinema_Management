package com.example.application.usecase.seance;

import com.example.application.dto.SeanceDTO;
import com.example.application.mapper.SeanceMapper;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllSeancesUseCase {

    private final SeanceRepository seanceRepository;

    public GetAllSeancesUseCase(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<SeanceDTO> execute() {
        return seanceRepository.findAll().stream()
                .map(SeanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
