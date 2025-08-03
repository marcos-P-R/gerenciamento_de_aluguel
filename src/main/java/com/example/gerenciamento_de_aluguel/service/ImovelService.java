package com.example.gerenciamento_de_aluguel.service;

import org.springframework.stereotype.Service;

import com.example.gerenciamento_de_aluguel.dto.request.ImovelDto;
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
}
