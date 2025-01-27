package com.example.application.usecase.client;

import com.example.application.dto.ClientDTO;
import com.example.application.mapper.ClientMapper;
import com.example.domain.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class GetClientByIdUseCase {

    private final ClientRepository clientRepository;

    public GetClientByIdUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO execute(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
    }
}
