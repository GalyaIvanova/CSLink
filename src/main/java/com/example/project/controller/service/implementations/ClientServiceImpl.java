package com.example.project.controller.service.implementations;

import com.example.project.controller.service.ClientService;
import com.example.project.model.data.exceptions.CustomResourceNotFoundException;
import com.example.project.model.dao.ClientRepository;
import com.example.project.model.dao.CosmetologistRepository;
import com.example.project.model.entities.Client;

import com.example.project.model.entities.Cosmetologist;
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

    @Override
    public List<Cosmetologist> getCosmetologists(Long clientId) throws CustomResourceNotFoundException {
        Client client = getClientById(clientId);
        return client.getCosmetologists();
    }

    @Override
    public void addCosmetologist(Long clientId, Long cosmetologistId) throws CustomResourceNotFoundException {
        Client client = getClientById(clientId);
        Cosmetologist cosmetologist = cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));
        client.addCosmetologist(cosmetologist);
        clientRepository.save(client);
    }

    @Override
    public void removeCosmetologist(Long clientId, Long cosmetologistId) throws CustomResourceNotFoundException {
        Client client = getClientById(clientId);
        Cosmetologist cosmetologist = cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));
        client.removeCosmetologist(cosmetologist);
        clientRepository.save(client);
    }

    @Override
    public void removeCosmetologistFromClient(Long clientId, Long cosmetologistId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Client", clientId));

        Cosmetologist cosmetologist = cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));

        client.removeCosmetologist(cosmetologist);
        clientRepository.save(client);
    }

    @Override
    public void addCosmetologistToClient(Long clientId, Long cosmetologistId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Client", clientId));

        Cosmetologist cosmetologist = cosmetologistRepository.findById(cosmetologistId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Cosmetologist", cosmetologistId));

        client.addCosmetologist(cosmetologist);
        clientRepository.save(client);
    }

    @Override
    public List<Cosmetologist> getCosmetologistsForClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Client", clientId));

        return client.getCosmetologists();
    }
}
