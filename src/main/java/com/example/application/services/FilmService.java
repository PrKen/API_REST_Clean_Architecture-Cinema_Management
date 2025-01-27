package com.example.application.services;

import com.example.application.dto.FilmDTO;
import com.example.application.usecase.film.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final GetAllFilmsUseCase getAllFilmsUseCase;
    private final GetFilmByIdUseCase getFilmByIdUseCase;
    private final AddFilmUseCase addFilmUseCase;
    private final DeleteFilmUseCase deleteFilmUseCase;
    private final FindFilmByCategoryUseCase findFilmByCategoryUseCase;
    private final UpdateFilmUseCase updateFilmUseCase;

    public FilmService(GetAllFilmsUseCase getAllFilmsUseCase,
                       GetFilmByIdUseCase getFilmByIdUseCase,
                       AddFilmUseCase addFilmUseCase,
                       DeleteFilmUseCase deleteFilmUseCase,
                       FindFilmByCategoryUseCase findFilmByCategoryUseCase,
                       UpdateFilmUseCase updateFilmUseCase) {
        this.getAllFilmsUseCase = getAllFilmsUseCase;
        this.getFilmByIdUseCase = getFilmByIdUseCase;
        this.addFilmUseCase = addFilmUseCase;
        this.deleteFilmUseCase = deleteFilmUseCase;
        this.findFilmByCategoryUseCase = findFilmByCategoryUseCase;
        this.updateFilmUseCase = updateFilmUseCase;
    }

    public List<FilmDTO> getAllFilms() {
        return getAllFilmsUseCase.execute();
    }

    public FilmDTO addFilm(FilmDTO filmDTO) {
        return addFilmUseCase.execute(filmDTO);
    }

    public void deleteFilm(Long id) {
        deleteFilmUseCase.execute(id);
    }

    public List<FilmDTO> getFilmsByCategory(String category) {
        return findFilmByCategoryUseCase.execute(category);
    }

    public FilmDTO updateFilm(Long id, FilmDTO filmDTO) {
        return updateFilmUseCase.execute(id, filmDTO);
    }

    public FilmDTO getFilmById(Long id) {
        return getFilmByIdUseCase.execute(id);
    }

}
