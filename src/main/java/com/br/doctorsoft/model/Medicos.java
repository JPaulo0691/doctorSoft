package com.br.doctorsoft.model;

import com.br.doctorsoft.dtos.Medicos.Request.MedicoDTO;
import com.br.doctorsoft.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medicos")
    @SequenceGenerator(name = "seq_medicos", sequenceName = "sequence_medicos", allocationSize = 1)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    public Medicos(MedicoDTO medicoDTO){
        this.nome = medicoDTO.getNome();
        this.crm = medicoDTO.getCrm();
        this.especialidade = EspecialidadeEnum.valueOf(medicoDTO.getEspecialidade());
    }
}
