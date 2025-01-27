package com.example.infrastructure.repository;

import com.example.domain.model.Client;
import com.example.domain.repository.ClientRepository;
import com.example.infrastructure.entity.ClientEntity;
import com.example.application.mapper.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository jpaClientRepository;

    public ClientRepositoryImpl(JpaClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll().stream()
                .map(ClientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(Long id) { // Implémentation pour GetClientByIdUseCase
        return jpaClientRepository.findById(id)
                .map(ClientMapper::toDomain);
    }

    @Override
    public void save(Client client) {
        ClientEntity entity = ClientMapper.toEntity(client);
        jpaClientRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        jpaClientRepository.deleteById(id);
    }

    @Override
    public List<Client> findByNomContaining(String nom) { // Implémentation pour FindClientByNameUseCase
        return jpaClientRepository.findByNomContainingIgnoreCase(nom).stream()
                .map(ClientMapper::toDomain)
                .collect(Collectors.toList());
    }
}
