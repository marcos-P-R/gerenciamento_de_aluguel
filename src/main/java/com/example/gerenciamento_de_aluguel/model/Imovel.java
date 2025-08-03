package com.example.gerenciamento_de_aluguel.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "IMOVEL_TB")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "num_quartos")
    private Integer numeroQuartos;

    @Column(name = "disponibilidade")
    private Boolean disponivel;

    public Imovel() {
    }

    public Imovel(String tipo, Endereco endereco, Integer capacidade, Integer numeroQuartos, Boolean disponivel) {
        this.tipo = tipo;
        this.endereco = endereco;
        this.capacidade = capacidade;
        this.numeroQuartos = numeroQuartos;
        this.disponivel = disponivel == null ? true : disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(Integer numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    
}
