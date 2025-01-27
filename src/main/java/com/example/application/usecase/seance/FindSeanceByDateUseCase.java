package com.example.application.usecase.seance;

import com.example.application.dto.SeanceDTO;
import com.example.application.mapper.SeanceMapper;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindSeanceByDateUseCase {

    private final SeanceRepository seanceRepository;

    public FindSeanceByDateUseCase(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<SeanceDTO> execute(LocalDate date) {
        return seanceRepository.findByDate(date).stream()
                .map(SeanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
