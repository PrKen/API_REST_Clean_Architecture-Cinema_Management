package com.example.application.services;

import com.example.application.dto.SeanceDTO;
import com.example.application.usecase.seance.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SeanceService {

    private final GetAllSeancesUseCase getAllSeancesUseCase;
    private final GetSeanceByIdUseCase getSeanceByIdUseCase;
    private final AddSeanceUseCase addSeanceUseCase;
    private final UpdateSeanceUseCase updateSeanceUseCase;
    private final DeleteSeanceUseCase deleteSeanceUseCase;
    private final FindSeanceByDateUseCase findSeanceByDateUseCase;
    private final FindSeanceByTimeUseCase findSeanceByTimeUseCase;
    private final FindSeanceByFilmUseCase findSeanceByFilmUseCase;
    private final FindSeanceBySalleUseCase findSeanceBySalleUseCase;

    public SeanceService(GetAllSeancesUseCase getAllSeancesUseCase,
                         GetSeanceByIdUseCase getSeanceByIdUseCase,
                         AddSeanceUseCase addSeanceUseCase,
                         UpdateSeanceUseCase updateSeanceUseCase,
                         DeleteSeanceUseCase deleteSeanceUseCase,
                         FindSeanceByDateUseCase findSeanceByDateUseCase,
                         FindSeanceByTimeUseCase findSeanceByTimeUseCase,
                         FindSeanceByFilmUseCase findSeanceByFilmUseCase,
                         FindSeanceBySalleUseCase findSeanceBySalleUseCase) {
        this.getAllSeancesUseCase = getAllSeancesUseCase;
        this.getSeanceByIdUseCase = getSeanceByIdUseCase;
        this.addSeanceUseCase = addSeanceUseCase;
        this.updateSeanceUseCase = updateSeanceUseCase;
        this.deleteSeanceUseCase = deleteSeanceUseCase;
        this.findSeanceByDateUseCase = findSeanceByDateUseCase;
        this.findSeanceByTimeUseCase = findSeanceByTimeUseCase;
        this.findSeanceByFilmUseCase = findSeanceByFilmUseCase;
        this.findSeanceBySalleUseCase = findSeanceBySalleUseCase;
    }

    public List<SeanceDTO> getAllSeances() {
        return getAllSeancesUseCase.execute();
    }

    public SeanceDTO getSeanceById(Long id) {
        return getSeanceByIdUseCase.execute(id);
    }

    public SeanceDTO addSeance(SeanceDTO seanceDTO) {
        return addSeanceUseCase.execute(seanceDTO);
    }

    public SeanceDTO updateSeance(Long id, SeanceDTO seanceDTO) {
        return updateSeanceUseCase.execute(id, seanceDTO);
    }

    public void deleteSeance(Long id) {
        deleteSeanceUseCase.execute(id);
    }

    public List<SeanceDTO> findSeancesByDate(LocalDate date) {
        return findSeanceByDateUseCase.execute(date);
    }

    public List<SeanceDTO> findSeancesByTime(LocalTime time) {
        return findSeanceByTimeUseCase.execute(time);
    }

    public List<SeanceDTO> findSeancesByFilm(Long filmId) {
        return findSeanceByFilmUseCase.execute(filmId);
    }

    public List<SeanceDTO> findSeancesBySalle(Long salleId) {
        return findSeanceBySalleUseCase.execute(salleId);
    }
}
