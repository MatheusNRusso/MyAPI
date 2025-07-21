package com.mylocal.myhospital.myapi.dto;

import com.mylocal.myhospital.myapi.model.Especialidade;
import com.mylocal.myhospital.myapi.model.Medico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoListarDto(

        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotBlank
        String email,

        @NotNull
        Especialidade especialidade) {

        public MedicoListarDto(Medico medico) {
                this(medico.getId(), medico.getNome(), medico.getCrm(),medico.getEmail(),medico.getEspecialidade());
        }
}
