package br.com.projeto.checkpointjava.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mensagens_sugestoes")
@Data
public class MensagemSugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensagem;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, length = 50)
    private String tipo; // alongamento / pausa / respiracao

    @Column(name = "nivel_estresse_minimo", length = 20)
    private String nivelEstresseMinimo; // baixo / medio / alto
}
