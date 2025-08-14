package com.example.gerenciamento_de_aluguel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciamento_de_aluguel.dto.request.ImovelDto;
import com.example.gerenciamento_de_aluguel.dto.request.ImovelDtoPatch;
import com.example.gerenciamento_de_aluguel.dto.request.ImovelDtoPut;
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

    @GetMapping
    public ResponseEntity<List<Imovel>> getAllImoveis() {
        return ResponseEntity.ok(imovelService.getAllImoveis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> getImovelById(@PathVariable Long id) {
        Imovel imovel = imovelService.getImovelById(id);
        return ResponseEntity.ok(imovel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> updateImovelPut(@PathVariable Long id, @Valid @RequestBody ImovelDtoPut imovelDto) {
        Imovel updatedImovel = imovelService.updateImovelPut(id, imovelDto);
        return ResponseEntity.ok(updatedImovel);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Imovel> updateImovelPatch(@PathVariable Long id, @Valid @RequestBody ImovelDtoPatch imovelDto) {
        Imovel updatedImovel = imovelService.updateImovelPatch(id, imovelDto);
        return ResponseEntity.ok(updatedImovel);
    }
}
