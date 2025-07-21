package com.mylocal.myhospital.myapi.dto;

import jakarta.validation.constraints.NotNull;

public record PacienteCadastroDto(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone
) {
}
