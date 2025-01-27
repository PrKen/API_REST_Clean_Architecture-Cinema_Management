package com.example.infrastructure.repository;

import com.example.application.mapper.FilmMapper;
import com.example.domain.model.Film;
import com.example.domain.repository.FilmRepository;
import com.example.infrastructure.entity.FilmEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FilmRepositoryImpl implements FilmRepository {

    private final JpaFilmRepository jpaFilmRepository;

    public FilmRepositoryImpl(JpaFilmRepository jpaFilmRepository) {
        this.jpaFilmRepository = jpaFilmRepository;
    }

    @Override
    public List<Film> findAll() { // Implémentation pour GetAllFilmsUseCase
        return jpaFilmRepository.findAll().stream()
                .map(FilmMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Film> findById(Long id) { // Implémentation pour GetFilmByIdUseCase
        return jpaFilmRepository.findById(id)
                .map(FilmMapper::toDomain);
    }

    @Override
    public void save(Film film) { // Implémentation pour AddFilmUseCase et UpdateFilmUseCase
        FilmEntity entity = FilmMapper.toEntity(film);
        jpaFilmRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) { // Implémentation pour DeleteFilmUseCase
        jpaFilmRepository.deleteById(id);
    }

    @Override
    public List<Film> findByCategorie(String categorie) { // Implémentation pour FindFilmByCategorieUseCase
        return jpaFilmRepository.findByCategorie(categorie).stream()
                .map(FilmMapper::toDomain)
                .collect(Collectors.toList());
    }
}
