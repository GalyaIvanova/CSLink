package com.example.project._recactor.model.mappers;

import com.example.project._recactor.controller.service.UserProfileService;
import com.example.project._useless.dto.ClientDTO;
import com.example.project._recactor.model.entities.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientAssembler {
    @Autowired
    private UserProfileService userProfileService;

    public ClientDTO toClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setUserProfileId(client.getUserProfile().getId());
        clientDTO.setAddress(client.getAddress());
//        clientDTO.setCreatedAt(client.getCreatedAt());
//        clientDTO.setUpdatedAt(client.getUpdatedAt());
        return clientDTO;
    }

    public Client toClientEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setUserProfile(userProfileService.getUserProfileById(clientDTO.getUserProfileId()));
        client.setAddress(clientDTO.getAddress());
        return client;
    }

}
