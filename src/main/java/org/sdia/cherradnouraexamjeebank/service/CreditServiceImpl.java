package org.sdia.cherradnouraexamjeebank.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sdia.cherradnouraexamjeebank.DTOs.CreditDTO;
import org.sdia.cherradnouraexamjeebank.DTOs.RemboursementDTO;
import org.sdia.cherradnouraexamjeebank.Repositories.ClientRepository;
import org.sdia.cherradnouraexamjeebank.Repositories.CreditRepository;
import org.sdia.cherradnouraexamjeebank.Repositories.RemboursementRepository;
import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.sdia.cherradnouraexamjeebank.entities.Credit;
import org.sdia.cherradnouraexamjeebank.entities.CreditPersonnel;
import org.sdia.cherradnouraexamjeebank.entities.Remboursement;
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
    @Autowired
    private  RemboursementRepository remboursementRepository;

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
    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                .orElseThrow(() -> new RuntimeException("Crédit introuvable"));

        Remboursement remboursement = new Remboursement();
        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setDate(remboursementDTO.getDate());
        remboursement.setCredit(credit);

        Remboursement saved = remboursementRepository.save(remboursement);

        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(saved.getId());
        dto.setMontant(saved.getMontant());
        dto.setDate(saved.getDate());
        dto.setCreditId(credit.getId());

        return dto;
    }
    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        Credit credit = new CreditPersonnel();
        credit.setMontant(creditDTO.getMontant());
        credit.setDateAcception(creditDTO.getDateAcception());
        credit.setClient(client);

        Credit saved = creditRepository.save(credit);

        CreditDTO dto = new CreditDTO();
        dto.setId(saved.getId());
        dto.setMontant(saved.getMontant());
        dto.setDateAcception(saved.getDateAcception());
        dto.setClientId(client.getId());

        return dto;
    }


}

