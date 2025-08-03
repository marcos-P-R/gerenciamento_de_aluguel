package com.example.gerenciamento_de_aluguel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciamento_de_aluguel.dto.request.ImovelDto;
import com.example.gerenciamento_de_aluguel.model.Imovel;
import com.example.gerenciamento_de_aluguel.service.ImovelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @PostMapping
    public ResponseEntity<Imovel> createImovel(@Valid @RequestBody ImovelDto imovel) {
        Imovel createdImovel = imovelService.createImovel(imovel);
        return new ResponseEntity<Imovel>(createdImovel, HttpStatus.CREATED);
    }
}
