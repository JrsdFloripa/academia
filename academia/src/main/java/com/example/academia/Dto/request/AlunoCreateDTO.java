package com.example.academia.Dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record AlunoCreateDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @NotBlank(message = "Bairro é obrigatório")
        String bairro,

        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataNascimento
) {}
