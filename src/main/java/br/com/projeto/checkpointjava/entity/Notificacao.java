package br.com.projeto.checkpointjava.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_notificacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 300)
    private String mensagem;

    @Column(nullable = false, length = 20)
    private String tipo; // lembrete / alerta / sugestão

    @Column(nullable = false)
    private LocalDateTime data_envio;

    @Column(nullable = false)
    private boolean visualizado;
}
