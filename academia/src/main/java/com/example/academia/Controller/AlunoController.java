package com.example.academia.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.academia.Dto.Response.AlunoResponseDTO;
import com.example.academia.Dto.request.AlunoCreateDTO;
import com.example.academia.Service.AlunoService;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public AlunoResponseDTO create(@Valid @RequestBody AlunoCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AlunoResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public AlunoResponseDTO findByNome(@PathVariable String nome) {
        return service.findByNome(nome);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO update(@PathVariable Long id, @Valid @RequestBody AlunoCreateDTO dto) {
        return service.update(id, dto);
    }

}
