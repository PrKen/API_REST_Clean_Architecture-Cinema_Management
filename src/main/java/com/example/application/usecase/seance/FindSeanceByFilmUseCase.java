package com.example.application.usecase.seance;

import com.example.application.dto.SeanceDTO;
import com.example.application.mapper.SeanceMapper;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindSeanceByFilmUseCase {

    private final SeanceRepository seanceRepository;

    public FindSeanceByFilmUseCase(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<SeanceDTO> execute(Long filmId) {
        return seanceRepository.findByFilmId(filmId).stream()
                .map(SeanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
