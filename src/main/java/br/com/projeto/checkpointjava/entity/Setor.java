package br.com.projeto.checkpointjava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "setores")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_setor;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String nome_setor;

    @Column(length = 255)
    private String descricao;
}
