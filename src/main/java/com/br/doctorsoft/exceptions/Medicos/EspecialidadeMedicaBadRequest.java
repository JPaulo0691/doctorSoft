package com.br.doctorsoft.exceptions.Medicos;

import com.br.doctorsoft.enums.EspecialidadeEnum;

public class EspecialidadeMedicaBadRequest extends IllegalArgumentException{

    public EspecialidadeMedicaBadRequest(EspecialidadeEnum especialidade){
        super(String.format("A especialidade que você inseriu não existe: %s", especialidade.toString()));
    }
}
