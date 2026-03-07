package com.matheus.claimflow.dto;

import com.matheus.claimflow.domain.enums.StatusSinistro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SinistroResponseDTO {

    private Long id;
    private String numero;
    private String descricao;
    private BigDecimal valorSolicitado;
    private LocalDateTime dataAbertura;
    private StatusSinistro status;

    public SinistroResponseDTO(Long id,
                               String numero,
                               String descricao,
                               BigDecimal valorSolicitado,
                               LocalDateTime dataAbertura,
                               StatusSinistro status) {

        this.id = id;
        this.numero = numero;
        this.descricao = descricao;
        this.valorSolicitado = valorSolicitado;
        this.dataAbertura = dataAbertura;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public StatusSinistro getStatus() {
        return status;
    }
}