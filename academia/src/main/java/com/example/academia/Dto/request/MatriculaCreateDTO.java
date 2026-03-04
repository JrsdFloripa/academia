package com.example.academia.Dto.request;

import jakarta.validation.constraints.NotNull;

public record MatriculaCreateDTO(
        @NotNull(message = "ID do aluno é obrigatório")
        Long alunoId
) {}
