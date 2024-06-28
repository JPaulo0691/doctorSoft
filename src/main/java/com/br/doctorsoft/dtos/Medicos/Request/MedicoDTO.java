package com.br.doctorsoft.dtos.Medicos.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MedicoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @NotBlank
    private String especialidade;

}
