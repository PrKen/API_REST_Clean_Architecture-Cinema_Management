package com.example.application.usecase.seance;

import com.example.domain.repository.SeanceRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteSeanceUseCase {

    private final SeanceRepository seanceRepository;

    public DeleteSeanceUseCase(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public void execute(Long id) {
        if (!seanceRepository.findById(id).isPresent()) {
            throw new RuntimeException("Seance not found with ID: " + id);
        }
        seanceRepository.deleteById(id);
    }
}
