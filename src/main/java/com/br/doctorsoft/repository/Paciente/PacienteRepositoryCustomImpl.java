package com.br.doctorsoft.repository.Paciente;

import com.br.doctorsoft.dtos.Pacientes.Response.PacienteResponse;
import com.br.doctorsoft.repository.Paciente.custom.PacienteRepositoryCustom;
import com.br.doctorsoft.utils.ConsultaPacienteSQL.ListarPacientesAtivosSQL;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PacienteRepositoryCustomImpl implements PacienteRepositoryCustom, RowMapper<PacienteResponse> {

    @Autowired
    private JdbcTemplate jdbc;

    private static final Logger logger = LoggerFactory.getLogger(PacienteRepositoryCustomImpl.class);

    @Override
    public PacienteResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacienteResponse response = new PacienteResponse();

        response.setNome(rs.getString("nome"));
        String data = rs.getString("data_de_nascimento");
        LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        response.setDataDeNascimento(date);
        response.setAtivo(rs.getString("ativo"));

        return response;
    }

    @Override
    public List<PacienteResponse> obterTodosPacientesAtivos() {

        logger.info("Executing custom query to find all active patients");
        String sql = ListarPacientesAtivosSQL.LISTAR_PACIENTES_ATIVOS;

        return jdbc.query(sql, new PacienteRepositoryCustomImpl());

    }
}
