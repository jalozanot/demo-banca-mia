package com.banca.mia.application.usercases.client;


import com.banca.mia.domain.model.Client;
import com.banca.mia.domain.port.in.client.CreateClientUseCase;
import com.banca.mia.domain.port.out.ClientRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    @Override
    public Client createClient(Client client) {
        return clientRepositoryPort.save(client);
    }
    
}
