package com.banca.mia.application.usercases.client;

import com.banca.mia.domain.model.Client;
import com.banca.mia.domain.port.in.client.GetClientUseCase;
import com.banca.mia.domain.port.out.ClientRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetClientUseCaseImpl implements GetClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepositoryPort.findById(id);
    }
}
