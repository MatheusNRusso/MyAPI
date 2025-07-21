package com.mylocal.myhospital.myapi.repository;

import com.mylocal.myhospital.myapi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
