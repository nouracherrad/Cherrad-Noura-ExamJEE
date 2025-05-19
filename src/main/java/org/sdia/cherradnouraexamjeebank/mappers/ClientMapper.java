package org.sdia.cherradnouraexamjeebank.mappers;

import org.sdia.cherradnouraexamjeebank.DTOs.ClientDTO;
import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.springframework.stereotype.Service;

@Service

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return client;
    }
}
