package com.example.gerenciamento_de_aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciamento_de_aluguel.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{
}
