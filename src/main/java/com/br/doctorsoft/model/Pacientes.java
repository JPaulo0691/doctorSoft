package com.br.doctorsoft.model;

import com.br.doctorsoft.dtos.Pacientes.Request.PacienteRequest;
import com.br.doctorsoft.dtos.Pacientes.Response.PacienteResponse;
import com.br.doctorsoft.utils.converters.ConversorDeData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pacientes")
    @SequenceGenerator(name = "seq_pacientes", sequenceName = "sequence_pacient", allocationSize = 1)
    private Long id;

    @NotBlank
    private String nome;

    @CPF
    @Column(unique = true,length = 11)
    private String cpf;

    @Convert(converter = ConversorDeData.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private Boolean ativo;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoricoCadastral> historicoCadastral = new ArrayList<>();

    public Pacientes(PacienteRequest pacienteRequest){
        this.nome = pacienteRequest.getNome();
        this.cpf = pacienteRequest.getCpf();
        this.dataDeNascimento = pacienteRequest.getDataDeNascimento();
        this.ativo = true;

        HistoricoCadastral historico = new HistoricoCadastral(LocalDate.now(),pacienteRequest.getMotivo(), this);
        this.historicoCadastral.add(historico);
    }
}
