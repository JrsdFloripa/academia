package com.example.academia.Controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.academia.Dto.Response.MatriculaResponseDto;
import com.example.academia.Dto.request.MatriculaCreateDTO;
import com.example.academia.Service.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    public MatriculaResponseDto create(@Valid @RequestBody MatriculaCreateDTO dto) {
        return service.create(dto);
    }
}