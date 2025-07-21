package com.mylocal.myhospital.myapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PacienteDto(
        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,


        EnderecoDto endereco)
{}
