package org.sdia.cherradnouraexamjeebank.service;

import org.sdia.cherradnouraexamjeebank.DTOs.RemboursementDTO;

import java.util.List;

public interface RemboursementService {
    RemboursementDTO createRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO getRemboursementById(Long id);
    List<RemboursementDTO> getAllRemboursements();
    void deleteRemboursement(Long id);
}
