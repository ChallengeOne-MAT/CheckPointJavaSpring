package br.com.projeto.checkpointjava.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gestores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gestor;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private Setor setor;
}
