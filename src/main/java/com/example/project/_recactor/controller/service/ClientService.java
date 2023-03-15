package com.example.project._recactor.controller.service;

import com.example.project._recactor.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project._recactor.model.entities.Client;
import com.example.project._recactor.model.entities.Cosmetologist;

import java.util.List;

public interface ClientService {
    Client getClientById(Long id) throws CustomResourceNotFoundException;

    Client createClient(Client client);

    Client updateClient(Long id, Client client);

    void deleteClientById(Long id) throws CustomResourceNotFoundException;

    List<Client> getAllClients();

    Client saveClient(Client client);

}
