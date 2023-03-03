package com.example.project.controller;


import com.example.project.controller.service.ClientService;
import com.example.project.model.entities.Client;
import com.example.project.model.entities.Cosmetologist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }

    @GetMapping("/{clientId}/cosmetologists")
    public ResponseEntity<List<Cosmetologist>> getCosmetologistsForClient(@PathVariable Long clientId) {
        List<Cosmetologist> cosmetologists = clientService.getCosmetologistsForClient(clientId);
        return ResponseEntity.ok().body(cosmetologists);
    }

    @PostMapping("/{clientId}/cosmetologists/{cosmetologistId}")
    public ResponseEntity<Void> addCosmetologistToClient(@PathVariable Long clientId, @PathVariable Long cosmetologistId) {
        clientService.addCosmetologistToClient(clientId, cosmetologistId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}/cosmetologists/{cosmetologistId}")
    public ResponseEntity<Void> removeCosmetologistFromClient(@PathVariable Long clientId, @PathVariable Long cosmetologistId) {
        clientService.removeCosmetologistFromClient(clientId, cosmetologistId);
        return ResponseEntity.ok().build();
    }
}
