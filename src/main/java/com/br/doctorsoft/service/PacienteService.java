package com.br.doctorsoft.service;

import com.br.doctorsoft.dtos.Pacientes.Request.PacienteRequest;
import com.br.doctorsoft.dtos.Pacientes.Response.PacienteResponse;
import com.br.doctorsoft.exceptions.PacienteNaoEncontradoException;
import com.br.doctorsoft.model.Pacientes;
import com.br.doctorsoft.repository.Paciente.PacienteRepository;
import com.br.doctorsoft.repository.Paciente.PacienteRepositoryCustomImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    @Autowired
    private PacienteRepositoryCustomImpl repositoryCustom;

    @Transactional
    public Pacientes cadastrarPaciente(PacienteRequest pacienteDto){

        Pacientes pacientes = new Pacientes(pacienteDto);

        return repository.save(pacientes);
    }

    public List<Pacientes>  listarTodosOsPacientes(){
        return repository.findAll();
    }

    public List<PacienteResponse> listarTodosOsPacientesAtivos(){
        return repositoryCustom.obterTodosPacientesAtivos();
    }

    public Pacientes encontrarPacientePorId(Long id){

        Optional<Pacientes> pacienteId = repository.findById(id);

        if(!pacienteId.isPresent()){
            throw new PacienteNaoEncontradoException();
        }

        Pacientes pacientes = pacienteId.get();

        return pacientes;
    }

    @Transactional
    public Pacientes atualizarCadastro(Long id, PacienteRequest pacienteRequest){

        Optional<Pacientes> encontrarPaciente = repository.findById(id);

        if(!encontrarPaciente.isPresent()){
            throw new PacienteNaoEncontradoException();
        }

        Pacientes atualizarCadastro = encontrarPaciente.get();

        atualizarCadastro.setNome(pacienteRequest.getNome());
        atualizarCadastro.setCpf(pacienteRequest.getCpf());
        atualizarCadastro.setDataDeNascimento(pacienteRequest.getDataDeNascimento());

        repository.save(atualizarCadastro);

        return atualizarCadastro;
    }

    @Transactional
    public Pacientes inativarCadastro(Long id){

        Optional<Pacientes> encontrarPaciente = repository.findById(id);

        if(!encontrarPaciente.isPresent()){
            throw new PacienteNaoEncontradoException();
        }

        Pacientes inativarCadastro = encontrarPaciente.get();

        inativarCadastro.setAtivo(false);
        repository.save(inativarCadastro);

        return inativarCadastro;

    }
}
