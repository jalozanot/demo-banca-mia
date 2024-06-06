package com.banca.mia.domain.port.in.client;


import com.banca.mia.domain.model.Client;

import java.util.Optional;

public interface GetClientUseCase {
    Optional<Client> getClient(Long id);

}
