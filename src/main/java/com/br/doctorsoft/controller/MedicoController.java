package com.br.doctorsoft.controller;

import com.br.doctorsoft.dtos.Medicos.Request.MedicoDTO;
import com.br.doctorsoft.enums.EspecialidadeEnum;
import com.br.doctorsoft.model.Medicos;
import com.br.doctorsoft.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Object> cadastroMedico(@RequestBody MedicoDTO medicos){

        try{
            var medicoCadastrado = medicoService.cadastrar(new Medicos(medicos));

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(medicoCadastrado);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EspecialidadeEnum.ESPECIALIDADE_NAO_CADASTRADA);
        }
    }

    @GetMapping
    public ResponseEntity<List<Medicos>> listarTodosOsMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.getAllMedicos());
    }

    @GetMapping("/{crm}")
    public ResponseEntity<Medicos> procurarMedicoPorCrm(@PathVariable String crm){

        var crmMedicoEncontrado = medicoService.getMedicoByCrm(crm);

        return ResponseEntity.status(HttpStatus.OK).body(crmMedicoEncontrado);
    }
}
