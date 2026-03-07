package com.matheus.claimflow.domain.entity;

import com.matheus.claimflow.domain.enums.StatusSinistro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String descricao;

    private BigDecimal valorSolicitado;

    private LocalDateTime dataAbertura;

    @Enumerated(EnumType.STRING)
    private StatusSinistro status;

    @ManyToOne
    @JoinColumn(name = "apolice_id")
    private Apolice apolice;

    public Sinistro() {
    }

    public Sinistro(Long id, String numero, BigDecimal valorSolicitado, LocalDateTime dataAbertura, StatusSinistro status, Apolice apolice) {
        this.id = id;
        this.numero = numero;
        this.valorSolicitado = valorSolicitado;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.apolice = apolice;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
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

    public Apolice getApolice() {
        return apolice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setStatus(StatusSinistro status) {
        this.status = status;
    }

    public void setApolice(Apolice apolice) {
        this.apolice = apolice;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}