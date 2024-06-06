package com.banca.mia.application.services;


import com.banca.mia.domain.model.Client;
import com.banca.mia.domain.port.in.client.CreateClientUseCase;
import com.banca.mia.domain.port.in.client.DeleteClientUseCase;
import com.banca.mia.domain.port.in.client.GetClientUseCase;
import com.banca.mia.domain.port.in.client.UpdateClientUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class ClientServices implements CreateClientUseCase, DeleteClientUseCase, GetClientUseCase, UpdateClientUseCase {

    private final CreateClientUseCase createClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final GetClientUseCase getClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;

    @Override
    public Client createClient(Client client) {
        return createClientUseCase.createClient(client);
    }

    @Override
    public boolean deleteClient(Long id) {
        return deleteClientUseCase.deleteClient(id);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return getClientUseCase.getClient(id);
    }

    @Override
    public Optional<Client> updateClient(Client updateClient) {
        return updateClientUseCase.updateClient(updateClient);
    }
}
