package org.sdia.cherradnouraexamjeebank.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sdia.cherradnouraexamjeebank.DTOs.ClientDTO;
import org.sdia.cherradnouraexamjeebank.Repositories.ClientRepository;
import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.sdia.cherradnouraexamjeebank.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
@AllArgsConstructor
@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        client = clientRepository.save(client);
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
