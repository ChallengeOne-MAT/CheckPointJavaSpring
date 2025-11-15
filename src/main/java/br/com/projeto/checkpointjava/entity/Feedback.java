package br.com.projeto.checkpointjava.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nivelEstresse;  // baixo / médio / alto

    @Column(nullable = false)
    private String humor; // emoji ou escala

    @Column(length = 300)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime dataFeedback;
}
