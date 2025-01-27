package com.example.application.usecase.salle;

import com.example.application.dto.SalleDTO;
import com.example.application.mapper.SalleMapper;
import com.example.domain.repository.SalleRepository;
import org.springframework.stereotype.Component;

@Component
public class GetSalleByIdUseCase {

    private final SalleRepository salleRepository;

    public GetSalleByIdUseCase(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public SalleDTO execute(Long id) {
        return salleRepository.findById(id)
                .map(SalleMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Salle not found with id: " + id));
    }
}
