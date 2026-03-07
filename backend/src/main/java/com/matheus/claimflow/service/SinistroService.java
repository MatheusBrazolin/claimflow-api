package com.matheus.claimflow.service;

import com.matheus.claimflow.domain.entity.Apolice;
import com.matheus.claimflow.domain.entity.Sinistro;
import com.matheus.claimflow.domain.enums.StatusSinistro;
import com.matheus.claimflow.dto.SinistroRequestDTO;
import com.matheus.claimflow.repository.ApoliceRepository;
import com.matheus.claimflow.repository.SinistroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SinistroService {

    private final SinistroRepository sinistroRepository;
    private final ApoliceRepository apoliceRepository;

    public SinistroService(SinistroRepository sinistroRepository,
                           ApoliceRepository apoliceRepository) {
        this.sinistroRepository = sinistroRepository;
        this.apoliceRepository = apoliceRepository;
    }

    public Sinistro salvar(SinistroRequestDTO dto) {

        Apolice apolice = apoliceRepository.findById(dto.apoliceId())
                .orElseThrow(() -> new RuntimeException("Apolice não encontrada"));

        Sinistro sinistro = new Sinistro();
        sinistro.setNumero(dto.numero());
        sinistro.setValorSolicitado(dto.valorSolicitado());
        sinistro.setDescricao(dto.descricao());
        sinistro.setDataAbertura(LocalDateTime.now());
        sinistro.setStatus(StatusSinistro.ABERTO);
        sinistro.setApolice(apolice);

        return sinistroRepository.save(sinistro);
    }

    public List<Sinistro> listarTodos() {
        return sinistroRepository.findAll();
    }

    public Sinistro buscarPorId(Long id) {
        return sinistroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sinistro não encontrado"));
    }

    public Sinistro atualizarStatus(Long id, StatusSinistro status) {
        Sinistro sinistro = buscarPorId(id);
        sinistro.setStatus(status);
        return sinistroRepository.save(sinistro);
    }
}