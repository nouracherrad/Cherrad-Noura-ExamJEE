package org.sdia.cherradnouraexamjeebank.web;

import org.sdia.cherradnouraexamjeebank.DTOs.CreditDTO;
import org.sdia.cherradnouraexamjeebank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    public ResponseEntity<CreditDTO> createCredit(@RequestBody CreditDTO creditDTO) {
        return new ResponseEntity<>(creditService.createCredit(creditDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
        CreditDTO creditDTO = creditService.getCreditById(id);
        return ResponseEntity.ok(creditDTO);
    }
}