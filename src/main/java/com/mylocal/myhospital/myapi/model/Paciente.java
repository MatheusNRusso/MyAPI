package com.mylocal.myhospital.myapi.model;

import com.mylocal.myhospital.myapi.dto.PacienteDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDto pacienteDto) {
        this.nome = pacienteDto.nome();
        this.cpf = pacienteDto.cpf();
        this.email = pacienteDto.email();
        this.telefone = pacienteDto.telefone();
        this.endereco = new Endereco(pacienteDto.endereco());
    }
}
