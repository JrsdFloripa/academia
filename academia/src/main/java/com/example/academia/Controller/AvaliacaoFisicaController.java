package com.example.academia.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.academia.Dto.Response.AvaliacaoFisicaResponseDTO;
import com.example.academia.Dto.request.AvaliacaoFisicaCreateDTO;
import com.example.academia.Service.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService service;

    public AvaliacaoFisicaController(AvaliacaoFisicaService service) {
        this.service = service;
    }

    @PostMapping
    public AvaliacaoFisicaResponseDTO create(@Valid @RequestBody AvaliacaoFisicaCreateDTO dto) {
        return service.create(dto);
    }
}