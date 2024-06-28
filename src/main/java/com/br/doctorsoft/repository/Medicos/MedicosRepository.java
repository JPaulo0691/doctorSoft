package com.br.doctorsoft.repository.Medicos;

import com.br.doctorsoft.model.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicosRepository extends JpaRepository<Medicos, Long> {

    Optional<Medicos> findByCrm(String crm);
}
