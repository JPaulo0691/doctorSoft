package com.br.doctorsoft.utils.ConsultaPacienteSQL;

public class ListarPacientesAtivosSQL {

    public final static String LISTAR_PACIENTES_ATIVOS =
            "SELECT P.NOME AS nome, " +
            "       DATA_DE_NASCIMENTO AS data_de_nascimento, " +
            "       CASE WHEN P.ATIVO = true " +
            "            THEN 'CADASTRO_ATIVO' " +
            "            ELSE 'CADASTRO_INATIVO' " +
            "       END AS ativo" +
            "  FROM PACIENTES P" +
            " WHERE P.ATIVO = TRUE";
}
