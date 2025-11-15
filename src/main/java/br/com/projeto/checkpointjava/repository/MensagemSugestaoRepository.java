package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.MensagemSugestao;
import br.com.projeto.checkpointjava.repository.MensagemSugestaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemSugestaoRepository extends JpaRepository<MensagemSugestao, Long> {
}
