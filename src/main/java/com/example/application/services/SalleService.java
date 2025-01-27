package com.example.application.services;

import com.example.application.dto.SalleDTO;
import com.example.application.usecase.salle.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {

    private final GetAllSallesUseCase getAllSallesUseCase;
    private final AddSalleUseCase addSalleUseCase;
    private final DeleteSalleUseCase deleteSalleUseCase;
    private final UpdateSalleUseCase updateSalleUseCase;
    private final GetSalleByIdUseCase getSalleByIdUseCase;

    public SalleService(GetAllSallesUseCase getAllSallesUseCase,
                        AddSalleUseCase addSalleUseCase,
                        DeleteSalleUseCase deleteSalleUseCase,
                        UpdateSalleUseCase updateSalleUseCase,
                        GetSalleByIdUseCase getSalleByIdUseCase) {
        this.getAllSallesUseCase = getAllSallesUseCase;
        this.addSalleUseCase = addSalleUseCase;
        this.deleteSalleUseCase = deleteSalleUseCase;
        this.updateSalleUseCase = updateSalleUseCase;
        this.getSalleByIdUseCase = getSalleByIdUseCase;
    }

    public List<SalleDTO> getAllSalles() {
        return getAllSallesUseCase.execute();
    }

    public SalleDTO addSalle(SalleDTO salleDTO) {
        return addSalleUseCase.execute(salleDTO);
    }

    public void deleteSalle(Long id) {
        deleteSalleUseCase.execute(id);
    }

    public SalleDTO updateSalle(Long id, SalleDTO salleDTO) {
        return updateSalleUseCase.execute(id, salleDTO);
    }

    public SalleDTO getSalleById(Long id) {
        return getSalleByIdUseCase.execute(id);
    }
}
