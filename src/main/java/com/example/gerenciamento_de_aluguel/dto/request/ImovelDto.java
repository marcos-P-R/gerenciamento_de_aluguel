package com.example.gerenciamento_de_aluguel.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ImovelDto(
    @Size(min = 3, max = 50, message = "O tipo do imóvel deve ter entre 3 e 50 caracteres")
    @NotEmpty(message = "O tipo do imóvel não pode ser vazio")
    String tipo,

    @NotNull(message = "O endereço do imóvel não pode ser vazio")
    @Valid EnderecoDto endereco,

    @Min(value = 1, message = "A capacidade do imóvel deve ser pelo menos 1")
    @NotNull(message = "A capacidade do imóvel não pode ser vazia")
    Integer capacidade,

    @Min(value = 1, message = "O número de quartos deve ser pelo menos 1")
    @NotNull(message = "O número de quartos não pode ser vazio")
    Integer numeroQuartos,
    
    Boolean disponivel
) {}
