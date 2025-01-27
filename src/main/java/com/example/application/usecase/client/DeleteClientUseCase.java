package com.example.application.usecase.client;

import com.example.domain.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientUseCase {

    private final ClientRepository clientRepository;

    public DeleteClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void execute(Long id) {
        clientRepository.deleteById(id);
    }
}
