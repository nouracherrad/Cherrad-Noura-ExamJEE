package org.sdia.cherradnouraexamjeebank.DTOs;

import java.time.LocalDate;
import lombok.Data;

@Data
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private Double montant;
    private String type;
    private Long creditId;
}

