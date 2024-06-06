package com.banca.mia.infrastructure.repositories;


import com.banca.mia.domain.model.Client;
import com.banca.mia.domain.port.out.ClientRepositoryPort;
import com.banca.mia.infrastructure.entities.ClientEntity;
import com.banca.mia.infrastructure.mapper.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class JpaClientRepositoryAdapter implements ClientRepositoryPort {

    private final JpaClientRepository jpaClientRepository;

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = ClientMapper.fromDomainModel(client);
        ClientEntity savedClientEntity = jpaClientRepository.save(clientEntity);
        return ClientMapper.toDomainModel(savedClientEntity);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaClientRepository.findById(id).map(ClientMapper::toDomainModel);
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll().stream()
                .map(ClientMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> update(Client client) {
        if (jpaClientRepository.existsById(client.getId())) {
            ClientEntity clientEntity = ClientMapper.fromDomainModel(client);
            ClientEntity updatedClientEntity = jpaClientRepository.save(clientEntity);
            return Optional.of(ClientMapper.toDomainModel(updatedClientEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaClientRepository.existsById(id)) {
            jpaClientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
