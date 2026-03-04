package com.example.academia.Dto.request;

import jakarta.validation.constraints.*;

public record AvaliacaoFisicaCreateDTO(

        @NotNull(message = "ID do aluno é obrigatório")
        @Min(value = 1, message = "ID do aluno deve ser maior que zero")
        Long alunoId,

        @NotNull(message = "Peso atual é obrigatório")
        @Positive(message = "Peso deve ser maior que zero")
        Double pesoAtual,

        @NotNull(message = "Altura atual é obrigatória")
        @Positive(message = "Altura deve ser maior que zero")
        Double alturaAtual
) {}


       