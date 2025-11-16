package br.com.projeto.checkpointjava.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tempo_tela")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempoTela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tempo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime inicio_sessao;

    private LocalDateTime fim_sessao;

    private Long duracao_minutos;
}
