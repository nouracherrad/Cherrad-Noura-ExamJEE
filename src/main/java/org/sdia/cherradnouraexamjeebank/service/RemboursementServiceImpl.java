package org.sdia.cherradnouraexamjeebank.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sdia.cherradnouraexamjeebank.DTOs.RemboursementDTO;
import org.sdia.cherradnouraexamjeebank.Repositories.RemboursementRepository;
import org.sdia.cherradnouraexamjeebank.entities.Remboursement;
import org.sdia.cherradnouraexamjeebank.mappers.RemboursementMapper;
import org.springframework.stereotype.Service;

import org.sdia.cherradnouraexamjeebank.Repositories.CreditRepository;
import org.sdia.cherradnouraexamjeebank.entities.Credit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
@AllArgsConstructor
@Slf4j
@Service
public class RemboursementServiceImpl implements RemboursementService {

    @Autowired
    private RemboursementRepository remboursementRepository;

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public RemboursementDTO createRemboursement(RemboursementDTO remboursementDTO) {
        Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        Remboursement remboursement = RemboursementMapper.toEntity(remboursementDTO, credit);
        remboursement = remboursementRepository.save(remboursement);
        return RemboursementMapper.toDTO(remboursement);
    }

    @Override
    public RemboursementDTO getRemboursementById(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        return RemboursementMapper.toDTO(remboursement);
    }

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(RemboursementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}

