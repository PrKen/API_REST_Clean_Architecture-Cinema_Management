package com.example.infrastructure.repository;

import com.example.application.mapper.SalleMapper;
import com.example.domain.model.Salle;
import com.example.domain.repository.SalleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SalleRepositoryImpl implements SalleRepository {

    private final JpaSalleRepository jpaSalleRepository;

    public SalleRepositoryImpl(JpaSalleRepository jpaSalleRepository) {
        this.jpaSalleRepository = jpaSalleRepository;
    }

    @Override
    public List<Salle> findAll() { // Implémentation pour GetAllSallesUseCase
        return jpaSalleRepository.findAll().stream()
                .map(SalleMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Salle> findById(Long id) { // Implémentation pour GetSalleByIdUseCase
        return jpaSalleRepository.findById(id)
                .map(SalleMapper::toDomain);
    }

    @Override
    public void save(Salle salle) { // Implémentation pour AddSalleUseCase et UpdateSalleUseCase
        jpaSalleRepository.save(SalleMapper.toEntity(salle));
    }

    @Override
    public void deleteById(Long id) { // Implémentation pour DeleteSalleUseCase
        jpaSalleRepository.deleteById(id);
    }
}
