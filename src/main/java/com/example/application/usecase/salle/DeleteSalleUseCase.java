package com.example.application.usecase.salle;

import com.example.domain.repository.SalleRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteSalleUseCase {

    private final SalleRepository salleRepository;

    public DeleteSalleUseCase(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public void execute(Long id) {
        if (!salleRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Salle not found with id: " + id);
        }
        salleRepository.deleteById(id);
    }
}
