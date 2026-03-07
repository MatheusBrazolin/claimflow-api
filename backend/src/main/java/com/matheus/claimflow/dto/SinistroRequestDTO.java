package com.matheus.claimflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record SinistroRequestDTO(

        @NotBlank(message = "Número do sinistro é obrigatório")
        String numero,

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        @NotNull(message = "Valor solicitado é obrigatório")
        @Positive(message = "Valor deve ser positivo")
        BigDecimal valorSolicitado,

        @NotNull(message = "ApoliceId é obrigatório")
        Long apoliceId

) {}