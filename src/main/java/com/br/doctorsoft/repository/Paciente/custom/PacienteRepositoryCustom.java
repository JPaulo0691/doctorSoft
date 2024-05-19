package com.br.doctorsoft.repository.Paciente.custom;

import com.br.doctorsoft.dtos.Pacientes.Response.PacienteResponse;

import java.util.List;

public interface PacienteRepositoryCustom {
    List<PacienteResponse> obterTodosPacientesAtivos();
}
