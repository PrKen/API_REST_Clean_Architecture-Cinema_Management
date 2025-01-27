package com.example.application.usecase.film;

import com.example.application.dto.FilmDTO;
import com.example.application.mapper.FilmMapper;
import com.example.domain.repository.FilmRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindFilmByCategoryUseCase {

    private final FilmRepository filmRepository;

    public FindFilmByCategoryUseCase(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDTO> execute(String category) {
        return filmRepository.findByCategorie(category).stream()
                .map(FilmMapper::toDto)
                .collect(Collectors.toList());
    }
}
