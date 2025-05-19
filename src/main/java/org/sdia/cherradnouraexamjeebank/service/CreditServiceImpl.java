package org.sdia.cherradnouraexamjeebank.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sdia.cherradnouraexamjeebank.DTOs.CreditDTO;
import org.sdia.cherradnouraexamjeebank.Repositories.ClientRepository;
import org.sdia.cherradnouraexamjeebank.Repositories.CreditRepository;
import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.sdia.cherradnouraexamjeebank.entities.Credit;
import org.sdia.cherradnouraexamjeebank.mappers.CreditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public CreditDTO createCredit(CreditDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Credit credit = CreditMapper.toEntity(creditDTO, client);
        credit = creditRepository.save(credit);
        return CreditMapper.toDTO(credit);
    }

    @Override
    public CreditDTO getCreditById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        return CreditMapper.toDTO(credit);
    }

    @Override
    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll().stream()
                .map(CreditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}

