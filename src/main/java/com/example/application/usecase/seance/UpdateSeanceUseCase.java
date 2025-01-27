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
public class UpdateSeanceUseCase {

    private final SeanceRepository seanceRepository;
    private final FilmRepository filmRepository;
    private final SalleRepository salleRepository;

    public UpdateSeanceUseCase(SeanceRepository seanceRepository,
                               FilmRepository filmRepository,
                               SalleRepository salleRepository) {
        this.seanceRepository = seanceRepository;
        this.filmRepository = filmRepository;
        this.salleRepository = salleRepository;
    }

    public SeanceDTO execute(Long id, SeanceDTO seanceDTO) {
        // Vérification de l'existence de la séance
        Seance existingSeance = seanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seance not found with ID: " + id));

        // Récupération du film
        Film film = filmRepository.findById(seanceDTO.getFilmId())
                .orElseThrow(() -> new RuntimeException("Film not found with ID: " + seanceDTO.getFilmId()));

        // Récupération de la salle
        Salle salle = salleRepository.findById(seanceDTO.getSalleId())
                .orElseThrow(() -> new RuntimeException("Salle not found with ID: " + seanceDTO.getSalleId()));

        // Mise à jour des champs
        existingSeance.setDate(seanceDTO.getDate());
        existingSeance.setHeure(seanceDTO.getHeure());
        existingSeance.setFilm(film);
        existingSeance.setSalle(salle);

        // Sauvegarde
        seanceRepository.save(existingSeance);

        return SeanceMapper.toDto(existingSeance);
    }
}
