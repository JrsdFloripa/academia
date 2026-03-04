package com.example.academia.Dto.Response;

import java.time.LocalDate;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String cpf,
        String bairro,
        LocalDate dataNascimento
) {}
