package com.banca.mia.application.usercases.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.banca.mia.domain.model.Client;
import com.banca.mia.domain.port.out.ClientRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GetClientUseCaseImplTest {

    @Mock
    private ClientRepositoryPort clientRepository;

    @InjectMocks
    private GetClientUseCaseImpl getClientUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClientById() {
        Client client = new Client();
        client.setId(Long.valueOf("1"));
        client.setName("Test Client");

        when(clientRepository.findById(Long.valueOf("1"))).thenReturn(Optional.of(client));

        Optional<Client> foundClient = getClientUseCase.getClient(Long.valueOf("1"));
        assertTrue(foundClient.isPresent());
        assertEquals(Long.valueOf("1"), foundClient.get().getId());
        assertEquals("Test Client", foundClient.get().getName());
    }
}
