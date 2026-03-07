package com.matheus.claimflow.service;

import com.matheus.claimflow.domain.entity.Apolice;
import com.matheus.claimflow.domain.enums.StatusApolice;
import com.matheus.claimflow.dto.ApoliceRequestDTO;
import com.matheus.claimflow.dto.ApoliceResponseDTO;
import com.matheus.claimflow.repository.ApoliceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApoliceService {

    private final ApoliceRepository apoliceRepository;

    public ApoliceService(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    public ApoliceResponseDTO criar(ApoliceRequestDTO dto) {

        Apolice apolice = new Apolice();
        apolice.setNumero(dto.numero());
        apolice.setSegurado(dto.segurado());
        apolice.setStatus(StatusApolice.ATIVA);

        Apolice salva = apoliceRepository.save(apolice);

        return new ApoliceResponseDTO(
                salva.getId(),
                salva.getNumero(),
                salva.getSegurado()
        );
    }

    public List<ApoliceResponseDTO> listar() {

        return apoliceRepository.findAll()
                .stream()
                .map(a -> new ApoliceResponseDTO(
                        a.getId(),
                        a.getNumero(),
                        a.getSegurado()
                ))
                .collect(Collectors.toList());
    }

    public ApoliceResponseDTO buscarPorId(Long id) {

        Apolice apolice = apoliceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apolice não encontrada"));

        return new ApoliceResponseDTO(
                apolice.getId(),
                apolice.getNumero(),
                apolice.getSegurado()
        );
    }

    public ApoliceResponseDTO atualizar(Long id, ApoliceRequestDTO dto) {

        Apolice apolice = apoliceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apólice não encontrada"));

        apolice.setNumero(dto.numero());
        apolice.setSegurado(dto.segurado());


        Apolice atualizada = apoliceRepository.save(apolice);

        return new ApoliceResponseDTO(
                atualizada.getId(),
                atualizada.getNumero(),
                atualizada.getSegurado()
        );
    }

    public void deletar(Long id) {

        Apolice apolice = apoliceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apólice não encontrada"));

        apoliceRepository.delete(apolice);
    }
}