package com.example.application.usecase.salle;

import com.example.application.dto.SalleDTO;
import com.example.application.mapper.SalleMapper;
import com.example.domain.repository.SalleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllSallesUseCase {

    private final SalleRepository salleRepository;

    public GetAllSallesUseCase(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<SalleDTO> execute() {
        return salleRepository.findAll().stream()
                .map(SalleMapper::toDto)
                .collect(Collectors.toList());
    }
}
