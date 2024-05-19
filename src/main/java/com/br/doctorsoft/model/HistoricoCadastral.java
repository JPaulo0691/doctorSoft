package com.br.doctorsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoricoCadastral {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico")
    @SequenceGenerator(name = "seq_historico", sequenceName = "sequence_historico", allocationSize = 1)
    private Long id;

    @NotNull(message = "A data de cadastro não deve ser nula")
    private LocalDate dataCadastro;

    private LocalDate dataAtualizacao;

    private LocalDate dataInativacao;

    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnore
    private Pacientes paciente;

    public HistoricoCadastral(LocalDate dataCadastro, String motivo, Pacientes paciente) {
        this.dataCadastro = dataCadastro;
        this.motivo = motivo;
        this.paciente = paciente;
    }

}
