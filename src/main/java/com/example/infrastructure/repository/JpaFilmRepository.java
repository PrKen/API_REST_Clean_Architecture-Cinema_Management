package com.example.infrastructure.repository;

import com.example.infrastructure.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaFilmRepository extends JpaRepository<FilmEntity, Long> {
    List<FilmEntity> findByCategorie(String categorie); // Requis pour FindFilmByCategorieUseCase
}
