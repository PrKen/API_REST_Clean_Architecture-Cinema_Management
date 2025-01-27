package com.example.application.usecase.film;

import com.example.application.dto.FilmDTO;
import com.example.application.mapper.FilmMapper;
import com.example.domain.repository.FilmRepository;
import org.springframework.stereotype.Component;

@Component
public class AddFilmUseCase {

    private final FilmRepository filmRepository;

    public AddFilmUseCase(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmDTO execute(FilmDTO filmDTO) {
        var film = FilmMapper.toDomain(filmDTO);
        filmRepository.save(film);
        return FilmMapper.toDto(film);
    }
}
