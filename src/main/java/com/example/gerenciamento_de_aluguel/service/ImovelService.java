package com.example.gerenciamento_de_aluguel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciamento_de_aluguel.dto.request.ImovelDto;
import com.example.gerenciamento_de_aluguel.dto.request.ImovelDtoPatch;
import com.example.gerenciamento_de_aluguel.dto.request.ImovelDtoPut;
import com.example.gerenciamento_de_aluguel.model.Endereco;
import com.example.gerenciamento_de_aluguel.model.Imovel;
import com.example.gerenciamento_de_aluguel.repository.ImovelRepository;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public Imovel createImovel(ImovelDto imovel) {
        Endereco endereco = new Endereco(
            imovel.endereco().rua(),
            imovel.endereco().numero(),
            imovel.endereco().bairro(),
            imovel.endereco().cidade(),
            imovel.endereco().estado(),
            imovel.endereco().cep(),
            imovel.endereco().complemento()
        );

        Imovel newImovel = new Imovel(
            imovel.tipo(),
            endereco,
            imovel.capacidade(),
            imovel.numeroQuartos(),
            imovel.disponivel()
        );

        return imovelRepository.save(newImovel);
    }

    public List<Imovel> getAllImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel getImovelById(Long id) {
        return imovelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imóvel não encontrado com o ID: " + id));
    }

    public Imovel updateImovelPut(Long id, ImovelDtoPut imovelDto) {
        Imovel existingImovel = imovelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imóvel não encontrado com o ID: " + id));

        Endereco endereco = existingImovel.getEndereco();
        endereco.setRua(imovelDto.endereco().rua());
        endereco.setNumero(imovelDto.endereco().numero());
        endereco.setBairro(imovelDto.endereco().bairro());
        endereco.setCidade(imovelDto.endereco().cidade());
        endereco.setEstado(imovelDto.endereco().estado());
        endereco.setCep(imovelDto.endereco().cep());
        endereco.setComplemento(imovelDto.endereco().complemento());

        existingImovel.setTipo(imovelDto.tipo());
        existingImovel.setCapacidade(imovelDto.capacidade());
        existingImovel.setNumeroQuartos(imovelDto.numeroQuartos());
        existingImovel.setDisponivel(imovelDto.disponivel());

        return imovelRepository.save(existingImovel);
    }

    public Imovel updateImovelPatch(Long id, ImovelDtoPatch imovelDto) {
        Imovel existingImovel = imovelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imóvel não encontrado com o ID: " + id));

        if (imovelDto.tipo() != null) existingImovel.setTipo(imovelDto.tipo());
        if (imovelDto.capacidade() != null) existingImovel.setCapacidade(imovelDto.capacidade());
        if (imovelDto.numeroQuartos() != null) existingImovel.setNumeroQuartos(imovelDto.numeroQuartos());
        if (imovelDto.disponivel() != null) existingImovel.setDisponivel(imovelDto.disponivel());

        if (imovelDto.endereco() != null) {
            Endereco endereco = existingImovel.getEndereco();
            if (imovelDto.endereco().rua() != null) endereco.setRua(imovelDto.endereco().rua());
            if (imovelDto.endereco().numero() != null) endereco.setNumero(imovelDto.endereco().numero());
            if (imovelDto.endereco().bairro() != null) endereco.setBairro(imovelDto.endereco().bairro());
            if (imovelDto.endereco().cidade() != null) endereco.setCidade(imovelDto.endereco().cidade());
            if (imovelDto.endereco().estado() != null) endereco.setEstado(imovelDto.endereco().estado());
            if (imovelDto.endereco().cep() != null) endereco.setCep(imovelDto.endereco().cep());
            if (imovelDto.endereco().complemento() != null) endereco.setComplemento(imovelDto.endereco().complemento());
        }

        return imovelRepository.save(existingImovel);
    }
}
