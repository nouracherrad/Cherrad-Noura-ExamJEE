package org.sdia.cherradnouraexamjeebank.DTOs;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private String statut;
    private LocalDate dateAcception;
    private Double montant;
    private int duree;
    private double tauxInteret;
    private Long clientId;
}

