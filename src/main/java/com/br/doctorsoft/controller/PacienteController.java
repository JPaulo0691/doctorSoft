package com.br.doctorsoft.controller;

import com.br.doctorsoft.dtos.Pacientes.Request.PacienteRequest;
import com.br.doctorsoft.dtos.Pacientes.Response.PacienteResponse;
import com.br.doctorsoft.model.Pacientes;
import com.br.doctorsoft.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<Pacientes> cadastrar(@RequestBody PacienteRequest pacienteRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(pacienteService.cadastrarPaciente(pacienteRequest));
=======
    public ResponseEntity<Pacientes> cadastrar(@RequestBody PacienteRequest pacienteDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(pacienteService.cadastrarPaciente(pacienteDto));
>>>>>>> origin/master
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos(){

        var listaPacientes = pacienteService.listarTodosOsPacientes();

        var listaPacienteResponse = listaPacientes.stream()
                                                  .map(PacienteResponse::new)
                                                  .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                             .body(listaPacienteResponse);
    }

    @GetMapping("/listarTodosPacientesAtivos")
    public ResponseEntity<List<PacienteResponse>> listarPacientesAtivos(){

        var listaPacientesAtivos = pacienteService.listarTodosOsPacientesAtivos();

        return ResponseEntity.status(HttpStatus.OK).body(listaPacientesAtivos);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteResponse> buscarPacientePorId(@PathVariable Long id){

        var paciente = pacienteService.encontrarPacientePorId(id);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(new PacienteResponse(paciente));
    }

    @PutMapping("/atualizarCadastro/{id}")
    public ResponseEntity<PacienteResponse> atualizacaoCadastral(@PathVariable Long id,@RequestBody PacienteRequest request){

        var atualizarCadastro = pacienteService.atualizarCadastro(id,request);

        return ResponseEntity.status(HttpStatus.OK).body(new PacienteResponse(atualizarCadastro));
    }

    @PutMapping("/inativarCadastro/{id}")
    public ResponseEntity<PacienteResponse> inativacaoCadastral(@PathVariable Long id){

        var inativarCadastro = pacienteService.inativarCadastro(id);

        return ResponseEntity.status(HttpStatus.OK).body(new PacienteResponse(inativarCadastro));
    }
}
