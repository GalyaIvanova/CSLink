package com.example.project._recactor.model.mappers;

import com.example.project.user.controller.service.UserProfileService;
import com.example.project._useless.dto.ClientDTO;
import com.example.project._recactor.model.entities.Client;
import com.example.project.user.controller.mapper.UserProfileMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientAssembler {
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserProfileMapper UserProfileMapper;
    public ClientDTO toDtoModel(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setUserProfileId(client.getUserProfile().getId());
//        clientDTO.setCreatedAt(client.getCreatedAt());
        return clientDTO;
    }

    public Client toClientEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setUserProfile(UserProfileMapper.toEntity(userProfileService.getUserProfileById(clientDTO.getUserProfileId())));
        return client;
    }

}
