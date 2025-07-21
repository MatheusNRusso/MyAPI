package com.mylocal.myhospital.myapi.model;

import com.mylocal.myhospital.myapi.dto.EnderecoDto;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String uf;
    private String cidade;
    private String numero;
    private String complemento;


    public Endereco(EnderecoDto enderecoDto) {

        if (enderecoDto != null) {
            System.out.println("EnderecoDto: " + enderecoDto);
        }
        this.logradouro = enderecoDto.logradouro();
        this.bairro = enderecoDto.bairro();
        this.cep = enderecoDto.cep();
        this.uf = enderecoDto.uf();
        this.cidade = enderecoDto.cidade();
        this.numero = enderecoDto.numero();
        this.complemento = enderecoDto.complemento();
    }

    public void atualizarCadastro(EnderecoDto endereco) {
        if (endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }

        if (endereco.bairro() != null) {
            this.bairro = endereco.bairro();
        }

        if (endereco.cep() != null) {
            this.cep = endereco.cep();

        }
        if (endereco.uf() != null) {
            this.uf = endereco.uf();
        }

        if (endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }

        if (endereco.numero() != null) {
            this.numero = endereco.numero();

        }
        if (endereco.complemento() != null) {
            this.complemento = endereco.complemento();
        }
    }
}
