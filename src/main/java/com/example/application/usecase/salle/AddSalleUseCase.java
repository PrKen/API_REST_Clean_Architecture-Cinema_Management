package com.example.application.usecase.salle;

import com.example.application.dto.SalleDTO;
import com.example.application.mapper.SalleMapper;
import com.example.domain.model.Salle;
import com.example.domain.repository.SalleRepository;
import org.springframework.stereotype.Component;

@Component
public class AddSalleUseCase {

    private final SalleRepository salleRepository;

    public AddSalleUseCase(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public SalleDTO execute(SalleDTO salleDTO) {
        Salle salle = SalleMapper.toDomain(salleDTO);
        salleRepository.save(salle);
        return SalleMapper.toDto(salle);
    }
}
