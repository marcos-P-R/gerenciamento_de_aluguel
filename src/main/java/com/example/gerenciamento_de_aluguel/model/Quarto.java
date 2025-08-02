package com.example.gerenciamento_de_aluguel.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "QUARTO_TB")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_do_quarto")
    private String numeroDoQuarto;

    @Column(name = "capacidade")
    private Integer capacidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imovel_id", referencedColumnName = "id")
    private Imovel imovelId;

    @Column(name = "ocupado")
    private Boolean ocupado;

    public Quarto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(String numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Imovel getImovelId() {
        return imovelId;
    }

    public void setImovelId(Imovel imovelId) {
        this.imovelId = imovelId;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    
}
