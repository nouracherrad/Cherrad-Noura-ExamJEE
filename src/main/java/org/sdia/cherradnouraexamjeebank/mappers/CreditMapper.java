package org.sdia.cherradnouraexamjeebank.mappers;

import org.sdia.cherradnouraexamjeebank.DTOs.CreditDTO;
import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.sdia.cherradnouraexamjeebank.entities.Credit;
import org.sdia.cherradnouraexamjeebank.entities.CreditPersonnel;
import org.springframework.stereotype.Service;

@Service

public class CreditMapper {
    public static CreditDTO toDTO(Credit credit) {
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant());
        dto.setDuree(credit.getDuree());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient().getId());
        return dto;
    }

    public static Credit toEntity(CreditDTO dto, Client client) {
        Credit credit = new CreditPersonnel();
        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcception(dto.getDateAcception());
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setClient(client);
        return credit;
    }
}

