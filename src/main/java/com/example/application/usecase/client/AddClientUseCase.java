package com.example.application.usecase.client;

import com.example.application.dto.ClientDTO;
import com.example.application.mapper.ClientMapper;
import com.example.domain.model.Client;
import com.example.domain.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class AddClientUseCase {

    private final ClientRepository clientRepository;

    public AddClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO execute(ClientDTO clientDTO) {
        Client client = ClientMapper.toDomain(clientDTO);
        clientRepository.save(client);
        return ClientMapper.toDto(client);
    }
}
