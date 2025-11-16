package br.com.projeto.checkpointjava.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacaoDTO {
    private Long usuarioId;
    private String titulo;
    private String mensagem;
    private String tipo;
}
