package br.com.projeto.checkpointjava.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDTO {
    private Long usuarioId;
    private String nivelEstresse;
    private String humor;
    private String comentario;
}
