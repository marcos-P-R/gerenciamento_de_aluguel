package com.example.gerenciamento_de_aluguel.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoDtoPut(
    @NotEmpty(message = "A rua não pode ser vazia")
    String rua,

    @NotEmpty(message = "O número não pode ser vazio")
    String numero,

    @NotEmpty(message = "O bairro não pode ser vazio")
    String bairro,

    @NotEmpty(message = "A cidade não pode ser vazia")
    String cidade,

    @NotEmpty(message = "O estado não pode ser vazio")
    String estado,
    
    @NotEmpty(message = "O CEP não pode ser vazio")
    @Size(min = 8, max = 9, message = "O CEP deve ter entre 8 e 9 caracteres")
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
    String cep,
    
    @NotEmpty(message = "O complemento não pode ser vazio")
    String complemento
) {
}
