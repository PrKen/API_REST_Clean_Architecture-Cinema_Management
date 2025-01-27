package com.example.application.usecase.film;

import com.example.domain.repository.FilmRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteFilmUseCase {

    private final FilmRepository filmRepository;

    public DeleteFilmUseCase(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void execute(Long id) {
        if (!filmRepository.findById(id).isPresent()) {
            throw new RuntimeException("Film not found with id: " + id);
        }
        filmRepository.deleteById(id);
    }
}
