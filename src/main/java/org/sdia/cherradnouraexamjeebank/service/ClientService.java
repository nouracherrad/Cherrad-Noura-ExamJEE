package org.sdia.cherradnouraexamjeebank.service;

import org.sdia.cherradnouraexamjeebank.DTOs.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    void deleteClient(Long id);
    ClientDTO saveClient(ClientDTO clientDTO);

}

