package com.mylocal.myhospital.myapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDto(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        @Pattern(regexp = "\\s{2}")
        String uf,

        @NotBlank
        String cidade,


        String numero,
        String complemento) {
}
