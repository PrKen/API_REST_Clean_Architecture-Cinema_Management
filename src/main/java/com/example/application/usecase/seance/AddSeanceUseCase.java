package com.example.application.usecase.seance;

import com.example.application.dto.SeanceDTO;
import com.example.application.mapper.SeanceMapper;
import com.example.domain.model.Film;
import com.example.domain.model.Salle;
import com.example.domain.model.Seance;
import com.example.domain.repository.FilmRepository;
import com.example.domain.repository.SalleRepository;
import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

@Component
public class AddSeanceUseCase {

    private final SeanceRepository seanceRepository;
    private final FilmRepository filmRepository;
    private final SalleRepository salleRepository;

    public AddSeanceUseCase(SeanceRepository seanceRepository,
                            FilmRepository filmRepository,
                            SalleRepository salleRepository) {
        this.seanceRepository = seanceRepository;
        this.filmRepository = filmRepository;
        this.salleRepository = salleRepository;
    }

    public SeanceDTO execute(SeanceDTO seanceDTO) {
        Film film = filmRepository.findById(seanceDTO.getFilmId())
                .orElseThrow(() -> new RuntimeException("Film not found with ID: " + seanceDTO.getFilmId()));

        Salle salle = salleRepository.findById(seanceDTO.getSalleId())
                .orElseThrow(() -> new RuntimeException("Salle not found with ID: " + seanceDTO.getSalleId()));

        Seance seance = SeanceMapper.toDomain(seanceDTO);
        seance.setFilm(film);
        seance.setSalle(salle);

        seanceRepository.save(seance);
        return SeanceMapper.toDto(seance);
    }
}
