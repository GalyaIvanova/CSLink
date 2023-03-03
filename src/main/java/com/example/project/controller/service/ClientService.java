package com.example.project.controller.service;

import com.example.project.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project.model.entities.Client;
import com.example.project.model.entities.Cosmetologist;

import java.util.List;

public interface ClientService {
    Client getClientById(Long id) throws CustomResourceNotFoundException;

    Client createClient(Client client);

    Client updateClient(Long id, Client client);

    void deleteClientById(Long id) throws CustomResourceNotFoundException;

    List<Client> getAllClients();

    Client saveClient(Client client);

    List<Cosmetologist> getCosmetologists(Long clientId) throws CustomResourceNotFoundException;

    void addCosmetologist(Long clientId, Long cosmetologistId) throws CustomResourceNotFoundException;

    void removeCosmetologist(Long clientId, Long cosmetologistId) throws CustomResourceNotFoundException;

    void removeCosmetologistFromClient(Long clientId, Long cosmetologistId);

    void addCosmetologistToClient(Long clientId, Long cosmetologistId);

    List<Cosmetologist> getCosmetologistsForClient(Long clientId);
}
