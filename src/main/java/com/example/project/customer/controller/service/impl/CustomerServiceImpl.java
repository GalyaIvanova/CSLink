package com.example.project.customer.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.cosmetologist.model.dataccess.dao.CosmetologistDao;
import com.example.project.customer.controller.service.CustomerService;
import com.example.project.customer.model.dataccess.dao.CustomerDao;
import com.example.project.customer.model.entity.Customer;
import com.example.project.exceptions.CustomResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao clientRepository;
    @Autowired
    private CosmetologistDao cosmetologistRepository;

    @Override
    public List<Customer> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer getClientById(Long id) {
        Optional<Customer> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new CustomResourceNotFoundException("Client", id);
        }
    }

    @Override
    public Customer saveClient(Customer client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClientById(Long id) throws CustomResourceNotFoundException {
        Optional<Customer> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new CustomResourceNotFoundException("Client", id);
        }
    }

    @Override
    @Transactional
    public Customer createClient(Customer client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Customer updateClient(Long id, Customer client) {
        Optional<Customer> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            client.setId(id);
            return clientRepository.save(client);
        } else {

            throw new CustomResourceNotFoundException("Client", id);
        }
    }

}
