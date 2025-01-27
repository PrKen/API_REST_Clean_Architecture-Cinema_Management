package com.example.application.usecase.salle;

import com.example.application.dto.SalleDTO;
import com.example.application.mapper.SalleMapper;
import com.example.domain.model.Salle;
import com.example.domain.repository.SalleRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateSalleUseCase {

    private final SalleRepository salleRepository;

    public UpdateSalleUseCase(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public SalleDTO execute(Long id, SalleDTO salleDTO) {
        // Vérification de l'existence de la salle
        Salle existingSalle = salleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salle not found with id: " + id));

        // Mise à jour des champs
        existingSalle.setNom(salleDTO.getNom());
        existingSalle.setCapacite(salleDTO.getCapacite());

        // Sauvegarde
        salleRepository.save(existingSalle);

        // Retourner le DTO mis à jour
        return SalleMapper.toDto(existingSalle);
    }
}
