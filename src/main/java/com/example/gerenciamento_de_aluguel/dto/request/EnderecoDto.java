package com.example.gerenciamento_de_aluguel.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoDto(
    String rua,
    String numero,
    String bairro,
    String cidade,
    String estado,
    
    @NotEmpty(message = "O CEP não pode ser vazio")
    @Size(min = 8, max = 9, message = "O CEP deve ter entre 8 e 9 caracteres")
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
    String cep,
    
    String complemento
) {}
