package com.example.application.usecase.client;

import com.example.application.dto.ClientDTO;
import com.example.application.mapper.ClientMapper;
import com.example.domain.model.Client;
import com.example.domain.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientUseCase {

    private final ClientRepository clientRepository;

    public UpdateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO execute(Long id, ClientDTO clientDTO) {
        // Vérification si le client existe
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));

        // Mise à jour des données
        existingClient.setNom(clientDTO.getNom());
        existingClient.setEmail(clientDTO.getEmail());

        // Sauvegarde des modifications
        clientRepository.save(existingClient);

        // Retour du DTO mis à jour
        return ClientMapper.toDto(existingClient);
    }
}
