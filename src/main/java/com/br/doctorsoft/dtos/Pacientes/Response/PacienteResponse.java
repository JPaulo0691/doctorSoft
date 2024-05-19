package com.br.doctorsoft.dtos.Pacientes.Response;

import com.br.doctorsoft.enums.PacienteAtivoEnum;
import com.br.doctorsoft.model.Pacientes;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private String ativo;

    public PacienteResponse(Pacientes pacientes){
        this.nome = pacientes.getNome();
        this.dataDeNascimento = pacientes.getDataDeNascimento();
        this.ativo = pacientes.getAtivo() ? PacienteAtivoEnum.CADASTRO_ATIVO.toString() :
                                            PacienteAtivoEnum.CADASTRO_INATIVO.toString();
    }
}
