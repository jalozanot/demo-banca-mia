package com.banca.mia.domain.port.in.client;


import com.banca.mia.domain.model.Client;

import java.util.Optional;

public interface UpdateClientUseCase {
    Optional<Client> updateClient(Client updateClient);

}
