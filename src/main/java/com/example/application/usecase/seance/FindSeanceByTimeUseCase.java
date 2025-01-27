package com.example.application.usecase.seance;

import com.example.application.dto.SeanceDTO;
import com.example.application.mapper.SeanceMapper;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindSeanceByTimeUseCase {

    private final SeanceRepository seanceRepository;

    public FindSeanceByTimeUseCase(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<SeanceDTO> execute(LocalTime time) {
        return seanceRepository.findByHeure(time).stream()
                .map(SeanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
