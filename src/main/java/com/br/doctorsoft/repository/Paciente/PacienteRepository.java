package com.br.doctorsoft.repository.Paciente;


import com.br.doctorsoft.model.Pacientes;
import com.br.doctorsoft.repository.Paciente.custom.PacienteRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes, Long> {
}
