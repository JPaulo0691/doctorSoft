package com.br.doctorsoft.dtos.Pacientes.Request;

import com.br.doctorsoft.model.HistoricoCadastral;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PacienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private String motivo;
}
