package com.example.project.model.mappers;

import com.example.project.controller.service.UserProfileService;
import com.example.project.model.dto.ClientDTO;
import com.example.project.model.dto.UserProfileDTO;
import com.example.project.model.entities.Client;
import com.example.project.model.entities.UserProfile;
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
