package org.sdia.cherradnouraexamjeebank.service;

import org.sdia.cherradnouraexamjeebank.DTOs.CreditDTO;

import java.util.List;

public interface CreditService {
    CreditDTO createCredit(CreditDTO creditDTO);
    CreditDTO getCreditById(Long id);
    List<CreditDTO> getAllCredits();
    void deleteCredit(Long id);
}

