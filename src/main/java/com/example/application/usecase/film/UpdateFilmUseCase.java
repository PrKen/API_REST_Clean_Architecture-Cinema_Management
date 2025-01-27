package com.example.application.usecase.film;

import com.example.application.dto.FilmDTO;
import com.example.application.mapper.FilmMapper;
import com.example.domain.model.Film;
import com.example.domain.repository.FilmRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateFilmUseCase {

    private final FilmRepository filmRepository;

    public UpdateFilmUseCase(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmDTO execute(Long id, FilmDTO filmDTO) {
        // Vérification de l'existence
        Film existingFilm = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with id: " + id));

        // Mise à jour
        existingFilm.setTitre(filmDTO.getTitre());
        existingFilm.setDescription(filmDTO.getDescription());
        existingFilm.setCategorie(filmDTO.getCategorie());

        filmRepository.save(existingFilm);

        return FilmMapper.toDto(existingFilm);
    }
}
