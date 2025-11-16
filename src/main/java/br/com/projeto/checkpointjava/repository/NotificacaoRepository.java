package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
