package com.example.domain.repository;

import com.example.domain.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {
    List<Film> findAll(); // Requis pour GetAllFilmsUseCase
    Optional<Film> findById(Long id); // Requis pour GetFilmByIdUseCase
    void save(Film film); // Requis pour AddFilmUseCase et UpdateFilmUseCase
    void deleteById(Long id); // Requis pour DeleteFilmUseCase
    List<Film> findByCategorie(String categorie); // Requis pour FindFilmByCategorieUseCase
}
