package com.banca.mia.domain.port.in.client;


import com.banca.mia.domain.model.Client;

public interface CreateClientUseCase {
    Client createClient(Client client);

}
