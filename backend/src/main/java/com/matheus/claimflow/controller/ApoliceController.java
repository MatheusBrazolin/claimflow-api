package com.matheus.claimflow.controller;

import com.matheus.claimflow.dto.ApoliceRequestDTO;
import com.matheus.claimflow.dto.ApoliceResponseDTO;
import com.matheus.claimflow.service.ApoliceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

    private final ApoliceService apoliceService;

    public ApoliceController(ApoliceService apoliceService) {
        this.apoliceService = apoliceService;
    }

    @PostMapping
    public ApoliceResponseDTO criar(@RequestBody ApoliceRequestDTO dto) {
        return apoliceService.criar(dto);
    }

    @GetMapping
    public List<ApoliceResponseDTO> listar() {
        return apoliceService.listar();
    }

    @PutMapping("/{id}")
    public ApoliceResponseDTO atualizar(@PathVariable Long id,
                                        @RequestBody ApoliceRequestDTO dto) {
        return apoliceService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        apoliceService.deletar(id);
    }

}