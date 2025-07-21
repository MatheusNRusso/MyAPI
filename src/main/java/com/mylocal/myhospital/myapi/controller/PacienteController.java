package com.mylocal.myhospital.myapi.controller;

import com.mylocal.myhospital.myapi.dto.PacienteDto;
import com.mylocal.myhospital.myapi.dto.PacienteListarDto;
import com.mylocal.myhospital.myapi.model.Paciente;
import com.mylocal.myhospital.myapi.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody PacienteDto pacienteDto) {
        pacienteRepository.save(new Paciente(pacienteDto));
        System.out.println("Paciente cadastrado com sucesso! " + pacienteDto);
    }
    @GetMapping
    public Page<PacienteListarDto> listarPaciente(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(PacienteListarDto::new);
    }
    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody PacienteDto pacienteDto) {

    }

}
