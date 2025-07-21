package com.mylocal.myhospital.myapi.dto;

import jakarta.validation.constraints.NotNull;

public record MedicoCadastroDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDto endereco) {
}
