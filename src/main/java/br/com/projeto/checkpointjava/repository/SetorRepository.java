package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {
}
