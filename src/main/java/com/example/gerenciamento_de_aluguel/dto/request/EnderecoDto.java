package com.example.gerenciamento_de_aluguel.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record EnderecoDto(
    String rua,
    String numero,
    String bairro,
    String cidade,
    String estado,
    @NotEmpty(message = "O CEP não pode ser vazio")
    String cep,
    String complemento
) {}
