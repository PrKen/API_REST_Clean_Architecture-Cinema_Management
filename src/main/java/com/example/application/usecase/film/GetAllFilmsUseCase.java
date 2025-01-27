package com.example.application.usecase.film;

import com.example.application.dto.FilmDTO;
import com.example.application.mapper.FilmMapper;
import com.example.domain.repository.FilmRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllFilmsUseCase {

    private final FilmRepository filmRepository;

    public GetAllFilmsUseCase(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDTO> execute() {
        return filmRepository.findAll().stream()
                .map(FilmMapper::toDto)
                .collect(Collectors.toList());
    }
}
