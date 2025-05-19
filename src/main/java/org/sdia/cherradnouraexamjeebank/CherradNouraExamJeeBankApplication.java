package org.sdia.cherradnouraexamjeebank;

import org.sdia.cherradnouraexamjeebank.DTOs.ClientDTO;
import org.sdia.cherradnouraexamjeebank.DTOs.CreditDTO;
import org.sdia.cherradnouraexamjeebank.DTOs.RemboursementDTO;
import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.sdia.cherradnouraexamjeebank.service.ClientService;
import org.sdia.cherradnouraexamjeebank.service.CreditService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import java.sql.Date;

@SpringBootApplication
public class CherradNouraExamJeeBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(CherradNouraExamJeeBankApplication.class, args);
    }


}