package com.br.doctorsoft.exceptions.Paciente;

import com.br.doctorsoft.utils.mensageExceptions.MensagensExceptions;
import jakarta.persistence.EntityNotFoundException;

public class PacienteNaoEncontradoException extends EntityNotFoundException {

    public PacienteNaoEncontradoException(){
        super(MensagensExceptions.PACIENTE_NAO_ENCONTRADO);
    }
}
