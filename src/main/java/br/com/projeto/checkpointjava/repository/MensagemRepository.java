package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
