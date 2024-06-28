package com.br.doctorsoft.service;

import com.br.doctorsoft.enums.EspecialidadeEnum;
import com.br.doctorsoft.exceptions.Medicos.EspecialidadeMedicaBadRequest;
import com.br.doctorsoft.model.Medicos;
import com.br.doctorsoft.repository.Medicos.MedicosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicosRepository medicosRepository;

    @Transactional
    public Medicos cadastrar(Medicos medicos){
        validarEspecialidade(medicos.getEspecialidade());
        return medicosRepository.save(medicos);
    }

    public void validarEspecialidade(EspecialidadeEnum especialidade){

        try{
            EspecialidadeEnum.valueOf(especialidade.toString());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Não há essa especialidade: " + e.getMessage());
        }
    }

    public List<Medicos> getAllMedicos(){
        return medicosRepository.findAll();
    }

    public Medicos getMedicoByCrm(String crm){

        var findCrm = medicosRepository.findByCrm(crm);

        if(findCrm.isEmpty()){
            throw new RuntimeException("Medico Não Encontrado nesta clínica");
        }

        Medicos medico =  findCrm.get();

        return medico;
    }
}
