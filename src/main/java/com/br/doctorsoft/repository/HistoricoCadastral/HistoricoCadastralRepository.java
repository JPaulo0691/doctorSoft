package com.br.doctorsoft.repository.HistoricoCadastral;

import com.br.doctorsoft.model.HistoricoCadastral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoCadastralRepository extends JpaRepository<HistoricoCadastral, Long> {

}
