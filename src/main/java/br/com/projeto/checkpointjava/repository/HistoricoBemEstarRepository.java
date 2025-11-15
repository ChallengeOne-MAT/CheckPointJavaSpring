package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.HistoricoBemEstar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoBemEstarRepository extends JpaRepository<HistoricoBemEstar, Long> {
}
