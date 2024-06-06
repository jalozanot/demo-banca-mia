package com.banca.mia.application.usercases.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.banca.mia.domain.model.Client;
import com.banca.mia.domain.port.out.ClientRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CreateClientUseCaseImplTest {

    @Mock
    private ClientRepositoryPort clientRepository;

    @InjectMocks
    private CreateClientUseCaseImpl createClientUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateClient() {
        Client client = new Client();
        client.setId(Long.valueOf("123"));
        client.setName("Test Client");

        when(clientRepository.save(any(Client.class))).thenReturn(client);

        Client createdClient = createClientUseCase.createClient(client);
        assertEquals(Long.valueOf("123"), createdClient.getId());
        assertEquals("Test Client", createdClient.getName());
    }
}
