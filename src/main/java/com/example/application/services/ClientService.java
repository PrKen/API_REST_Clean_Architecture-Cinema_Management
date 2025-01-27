package com.example.application.services;

import com.example.application.dto.ClientDTO;
import com.example.application.usecase.client.AddClientUseCase;
import com.example.application.usecase.client.DeleteClientUseCase;
import com.example.application.usecase.client.FindClientByNameUseCase;
import com.example.application.usecase.client.GetAllClientsUseCase;
import com.example.application.usecase.client.GetClientByIdUseCase;
import com.example.application.usecase.client.UpdateClientUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final GetAllClientsUseCase getAllClientsUseCase;
    private final GetClientByIdUseCase getClientByIdUseCase;
    private final AddClientUseCase addClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final FindClientByNameUseCase findClientByNameUseCase;
    private final UpdateClientUseCase updateClientUseCase;

    public ClientService(GetAllClientsUseCase getAllClientsUseCase,
                         GetClientByIdUseCase getClientByIdUseCase,
                         AddClientUseCase addClientUseCase,
                         DeleteClientUseCase deleteClientUseCase,
                         FindClientByNameUseCase findClientByNameUseCase,
                         UpdateClientUseCase updateClientUseCase) {
        this.getAllClientsUseCase = getAllClientsUseCase;
        this.getClientByIdUseCase = getClientByIdUseCase;
        this.addClientUseCase = addClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.findClientByNameUseCase = findClientByNameUseCase;
        this.updateClientUseCase = updateClientUseCase;
    }

    public List<ClientDTO> getAllClients() {
        return getAllClientsUseCase.execute();
    }

    public ClientDTO getClientById(Long id) {
        return getClientByIdUseCase.execute(id);
    }

    public ClientDTO addClient(ClientDTO clientDTO) {
        return addClientUseCase.execute(clientDTO);
    }

    public void deleteClient(Long id) {
        deleteClientUseCase.execute(id);
    }

    public List<ClientDTO> findByName(String name) {
        return findClientByNameUseCase.execute(name);
    }

    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        return updateClientUseCase.execute(id, clientDTO);
    }
}
