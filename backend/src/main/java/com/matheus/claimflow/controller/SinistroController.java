package com.matheus.claimflow.controller;

import com.matheus.claimflow.domain.entity.Sinistro;
import com.matheus.claimflow.domain.enums.StatusSinistro;
import com.matheus.claimflow.dto.SinistroRequestDTO;
import com.matheus.claimflow.dto.SinistroResponseDTO;
import com.matheus.claimflow.service.SinistroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sinistros")
public class SinistroController {

    private final SinistroService sinistroService;

    public SinistroController(SinistroService sinistroService) {
        this.sinistroService = sinistroService;
    }

    @PostMapping
    public SinistroResponseDTO criar(@RequestBody @Valid SinistroRequestDTO dto) {

        Sinistro salvo = sinistroService.salvar(dto);

        return new SinistroResponseDTO(
                salvo.getId(),
                salvo.getNumero(),
                salvo.getDescricao(),
                salvo.getValorSolicitado(),
                salvo.getDataAbertura(),
                salvo.getStatus()
        );
    }

    @GetMapping
    public List<SinistroResponseDTO> listar() {
        return sinistroService.listarTodos()
                .stream()
                .map(s -> new SinistroResponseDTO(
                        s.getId(),
                        s.getNumero(),
                        s.getDescricao(),
                        s.getValorSolicitado(),
                        s.getDataAbertura(),
                        s.getStatus()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}/em-analise")
    public SinistroResponseDTO colocarEmAnalise(@PathVariable Long id) {

        Sinistro sinistro = sinistroService.atualizarStatus(id, StatusSinistro.EM_ANALISE);

        return new SinistroResponseDTO(
                sinistro.getId(),
                sinistro.getNumero(),
                sinistro.getDescricao(),
                sinistro.getValorSolicitado(),
                sinistro.getDataAbertura(),
                sinistro.getStatus()
        );
    }

    @PutMapping("/{id}/aprovar")
    public SinistroResponseDTO aprovar(@PathVariable Long id) {

        Sinistro sinistro = sinistroService.atualizarStatus(id, StatusSinistro.APROVADO);

        return new SinistroResponseDTO(
                sinistro.getId(),
                sinistro.getNumero(),
                sinistro.getDescricao(),
                sinistro.getValorSolicitado(),
                sinistro.getDataAbertura(),
                sinistro.getStatus()
        );
    }

    @PutMapping("/{id}/rejeitar")
    public SinistroResponseDTO rejeitar(@PathVariable Long id) {

        Sinistro sinistro = sinistroService.atualizarStatus(id, StatusSinistro.REJEITADO);

        return new SinistroResponseDTO(
                sinistro.getId(),
                sinistro.getNumero(),
                sinistro.getDescricao(),
                sinistro.getValorSolicitado(),
                sinistro.getDataAbertura(),
                sinistro.getStatus()
        );
    }
}