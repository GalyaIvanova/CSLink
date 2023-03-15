package com.example.project._recactor.controller.service.implementations;

import com.example.project._recactor.controller.service.ClientService;
import com.example.project._recactor.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project._recactor.model.dao.ClientRepository;
import com.example.project._recactor.model.dao.CosmetologistRepository;
import com.example.project._recactor.model.entities.Client;

import com.example.project._recactor.model.entities.Cosmetologist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    private final CosmetologistRepository cosmetologistRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CosmetologistRepository cosmetologistRepository) {
        this.clientRepository = clientRepository;
        this.cosmetologistRepository = cosmetologistRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new CustomResourceNotFoundException("Client", id);
        }
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClientById(Long id) throws CustomResourceNotFoundException {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new CustomResourceNotFoundException("Client", id);
        }
    }

    @Override
    @Transactional
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            client.setId(id);
            return clientRepository.save(client);
        } else {

            throw new CustomResourceNotFoundException("Client", id);
        }
    }








}
