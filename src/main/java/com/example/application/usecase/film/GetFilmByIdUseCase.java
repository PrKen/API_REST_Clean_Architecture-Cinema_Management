package com.example.application.usecase.film;

import com.example.application.dto.FilmDTO;
import com.example.application.mapper.FilmMapper;
import com.example.domain.repository.FilmRepository;
import org.springframework.stereotype.Component;

@Component
public class GetFilmByIdUseCase {

    private final FilmRepository filmRepository;

    public GetFilmByIdUseCase(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmDTO execute(Long id) {
        return filmRepository.findById(id)
                .map(FilmMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Film not found with id: " + id));
    }
}
