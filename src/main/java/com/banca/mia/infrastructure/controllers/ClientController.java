package com.banca.mia.infrastructure.controllers;


import com.banca.mia.application.services.ClientServices;
import com.banca.mia.domain.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {

    private final ClientServices clientServices;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientServices.createClient(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        return clientServices.getClient(clientId)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client upateClient) {
        return clientServices.updateClient(upateClient)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long clientId) {
        if (clientServices.deleteClient(clientId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
