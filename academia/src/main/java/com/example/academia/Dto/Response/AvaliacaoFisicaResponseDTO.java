package com.example.academia.Dto.Response;

import java.time.LocalDateTime;

public record AvaliacaoFisicaResponseDTO(
        Long id,
        LocalDateTime dataAvaliacao,
        Double pesoAtual,
        Double alturaAtual,
        Long alunoId
) {}