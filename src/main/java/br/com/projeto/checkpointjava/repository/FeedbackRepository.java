package br.com.projeto.checkpointjava.repository;

import br.com.projeto.checkpointjava.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
