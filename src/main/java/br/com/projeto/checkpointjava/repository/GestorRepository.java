package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository<Gestor, Long> {

    boolean existsByEmail(String email);
}
