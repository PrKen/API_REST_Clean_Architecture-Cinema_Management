package com.example.application.usecase.client;

import com.example.application.dto.ClientDTO;
import com.example.application.mapper.ClientMapper;
import com.example.domain.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindClientByNameUseCase {

    private final ClientRepository clientRepository;

    public FindClientByNameUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> execute(String name) {
        return ClientMapper.toDtoList(clientRepository.findByNomContaining(name));
    }
}
