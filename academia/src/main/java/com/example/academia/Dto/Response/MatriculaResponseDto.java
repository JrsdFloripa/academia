package com.example.academia.Dto.Response;

import java.time.LocalDateTime;

public record MatriculaResponseDto(
        Long id,
        LocalDateTime dataMatricula,
        Long alunoId
) {}