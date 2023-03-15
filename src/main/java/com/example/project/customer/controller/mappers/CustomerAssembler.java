package com.example.project.customer.controller.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.customer.model.dto.CustomerDTO;
import com.example.project.customer.model.entity.Customer;
import com.example.project.user.controller.mappers.UserProfileMapper;
import com.example.project.user.controller.service.UserProfileService;

@Component
public class CustomerAssembler {
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserProfileMapper UserProfileMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO toDtoModel(Customer client) {
        CustomerDTO clientDTO = customerMapper.toDtoModel(client);
        return clientDTO;
    }

    public Customer toClientEntity(CustomerDTO clientDTO) {
        Customer client = customerMapper.toClientEntity(clientDTO);
        client.setUserProfile(UserProfileMapper.toEntity(userProfileService.getUserProfileById(client.getId())));
        return client;
    }
}
