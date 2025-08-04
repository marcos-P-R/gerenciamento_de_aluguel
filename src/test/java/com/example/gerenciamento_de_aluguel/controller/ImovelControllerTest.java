package com.example.gerenciamento_de_aluguel.controller;

import com.example.gerenciamento_de_aluguel.dto.request.EnderecoDto;
import com.example.gerenciamento_de_aluguel.dto.request.ImovelDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ImovelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createImovel_comDadosValidos_deveRetornarImovelCriado() throws Exception {

        EnderecoDto enderecoDto = new EnderecoDto(
                "Rua dos Testes",
                "123",
                "Centro",
                "Cidade Teste",
                "TS",
                "99999-000",
                null);

        ImovelDto imovelDto = new ImovelDto("Casa", enderecoDto, 5, 3, true);

        mockMvc.perform(post("/imoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imovelDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.tipo").value("Casa"))
                .andExpect(jsonPath("$.capacidade").value(5))
                .andExpect(jsonPath("$.endereco.rua").value("Rua dos Testes"))
                .andExpect(jsonPath("$.endereco.cep").value("99999-000"));
    }

    @Test
    void createImovel_comCapacidadeInvalida_deveRetornarErro() throws Exception {

        EnderecoDto enderecoDto = new EnderecoDto(
                "Rua dos Testes",
                "123",
                "Centro",
                "Cidade Teste",
                "TS",
                "99999-000",
                null);

        ImovelDto imovelDto = new ImovelDto("Casa", enderecoDto, 0, 3, true);

        mockMvc.perform(post("/imoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imovelDto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].field").value("capacidade"))
                .andExpect(jsonPath("$[0].error").value("A capacidade do imóvel não pode ser vazia"));
    }

    @Test
    void createImovel_comQuantidadeDeQuartosInvalida_deveRetornaErro() throws Exception {
        EnderecoDto enderecoDto = new EnderecoDto(
                "wwwww",
                "123",
                "Centro",
                "Cidade Teste",
                "TS",
                "99999-000",
                null);
        ImovelDto imovelDto = new ImovelDto("", enderecoDto, 0, -1, true);

        mockMvc.perform(post("/imoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imovelDto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].field").value("numeroQuartos"))
                .andExpect(jsonPath("$[0].error").value("O número de quartos deve ser pelo menos 1"));
    }

    @Test
    void createImovel_comTipoInvalido_deveRetornarErro() throws Exception {
        EnderecoDto enderecoDto = new EnderecoDto(
                "Rua dos Testes",
                "123",
                "Centro",
                "Cidade Teste",
                "TS",
                "99999-000",
                null);
        ImovelDto imovelDto = new ImovelDto("", enderecoDto, 0, 3, true);

        mockMvc.perform(post("/imoveis")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imovelDto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].field").value("tipo"))
                .andExpect(jsonPath("$[0].error").value("O tipo do imóvel não pode ser vazio"));
    }
}
