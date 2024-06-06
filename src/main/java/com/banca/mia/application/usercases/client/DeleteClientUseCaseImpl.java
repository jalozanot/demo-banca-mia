package com.banca.mia.application.usercases.client;


import com.banca.mia.domain.port.in.client.DeleteClientUseCase;
import com.banca.mia.domain.port.out.ClientRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteClientUseCaseImpl implements DeleteClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    @Override
    public boolean deleteClient(Long id) {
        return clientRepositoryPort.deleteById(id);
    }

}
