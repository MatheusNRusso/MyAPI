package com.mylocal.myhospital.myapi.model;

import com.mylocal.myhospital.myapi.dto.MedicoCadastroDto;
import com.mylocal.myhospital.myapi.dto.MedicoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico(MedicoDto medicoDto) {
        this.nome = medicoDto.nome();
        this.email = medicoDto.email();
        this.crm = medicoDto.crm();
        this.telefone = medicoDto.telefone();
        this.especialidade = medicoDto.especialidade();
        this.endereco = new Endereco(medicoDto.endereco());
        this.ativo = true;
    }

    public Medico(@NotBlank String nome, @NotBlank @Pattern(regexp = "\\d{4,6}") String crm, @NotBlank String email, @NotNull Especialidade especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.email = email;
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", crm='" + crm + '\'' +
                ", telefone='" + telefone + '\'' +
                ", especialidade=" + especialidade +
                '}';
    }



    public void atualizarCadastro(MedicoCadastroDto medicoCadastroDto) {

        if (medicoCadastroDto.nome() != null) {
            this.nome = medicoCadastroDto.nome();
        }

        if (medicoCadastroDto.telefone() != null) {
            this.telefone = medicoCadastroDto.telefone();
        }

        if (medicoCadastroDto.endereco() != null) {
            this.endereco.atualizarCadastro(medicoCadastroDto.endereco());
        }

    }

    public void desativar() {
        this.ativo = false;
    }
}
