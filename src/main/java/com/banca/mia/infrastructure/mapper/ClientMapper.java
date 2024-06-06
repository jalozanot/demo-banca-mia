package com.banca.mia.infrastructure.mapper;

import com.banca.mia.domain.model.Client;
import com.banca.mia.infrastructure.entities.ClientEntity;

public class ClientMapper {

    public static ClientEntity fromDomainModel(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .dni(client.getDni())
                .name(client.getName())
                .lastName(client.getLastName())
                .numberIdentification(client.getNumberIdentification())
                .creationDate(client.getCreationDate()).build();
    }

    public static Client toDomainModel(ClientEntity clientEntity) {
        return Client.builder()
                .id(clientEntity.getId())
                .dni(clientEntity.getDni())
                .name(clientEntity.getName())
                .lastName(clientEntity.getLastName())
                .creationDate(clientEntity.getCreationDate())
                .numberIdentification(clientEntity.getNumberIdentification()).build();
    }
}
