package com.matheus.claimflow.domain.entity;

import com.matheus.claimflow.domain.enums.StatusApolice;
import jakarta.persistence.*;

@Entity
public class Apolice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String segurado;

    @Enumerated(EnumType.STRING)
    private StatusApolice status;

    public Apolice() {
    }

    public Apolice(Long id, String numero, String segurado, StatusApolice status) {
        this.id = id;
        this.numero = numero;
        this.segurado = segurado;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getSegurado() {
        return segurado;
    }

    public StatusApolice getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSegurado(String segurado) {
        this.segurado = segurado;
    }

    public void setStatus(StatusApolice status) {
        this.status = status;
    }
}