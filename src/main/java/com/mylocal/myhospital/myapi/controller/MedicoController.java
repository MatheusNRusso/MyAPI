package com.mylocal.myhospital.myapi.controller;

import com.mylocal.myhospital.myapi.dto.MedicoCadastroDto;
import com.mylocal.myhospital.myapi.dto.MedicoDto;
import com.mylocal.myhospital.myapi.dto.MedicoListarDto;
import com.mylocal.myhospital.myapi.model.Medico;
import com.mylocal.myhospital.myapi.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastraMedico(@RequestBody @Valid MedicoDto medicoDto) {
        medicoRepository.save(new Medico(medicoDto));
        System.out.println("Medico cadastrado com sucesso!" + medicoDto);
    }

    @GetMapping
    public Page<MedicoListarDto> listarMedicos(
            @PageableDefault(size =  10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoIsTrue(pageable).map(MedicoListarDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid MedicoCadastroDto medicoCadastroDto) {

        var medico = medicoRepository.getReferenceById(medicoCadastroDto.id());
        medico.atualizarCadastro(medicoCadastroDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.desativar();
    }
}
