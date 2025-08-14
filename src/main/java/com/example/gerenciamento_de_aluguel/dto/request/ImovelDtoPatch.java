package com.example.gerenciamento_de_aluguel.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record ImovelDtoPatch(
    @Size(min = 3, max = 50, message = "O tipo do imóvel deve ter entre 3 e 50 caracteres")
    String tipo,

    @Valid EnderecoDto endereco,

    @Min(value = 1, message = "A capacidade do imóvel deve ser pelo menos 1")
    Integer capacidade,

    @Min(value = 1, message = "O número de quartos deve ser pelo menos 1")
    Integer numeroQuartos,

    Boolean disponivel
) {

}
