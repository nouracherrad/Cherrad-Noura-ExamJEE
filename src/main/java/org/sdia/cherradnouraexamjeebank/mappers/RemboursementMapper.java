package org.sdia.cherradnouraexamjeebank.mappers;

import org.sdia.cherradnouraexamjeebank.DTOs.RemboursementDTO;
import org.sdia.cherradnouraexamjeebank.entities.Credit;
import org.sdia.cherradnouraexamjeebank.entities.Remboursement;

public class RemboursementMapper {
    public static RemboursementDTO toDTO(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());
        dto.setCreditId(remboursement.getCredit().getId());
        return dto;
    }

    public static Remboursement toEntity(RemboursementDTO dto, Credit credit) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(dto.getType());
        remboursement.setCredit(credit);
        return remboursement;
    }
}

