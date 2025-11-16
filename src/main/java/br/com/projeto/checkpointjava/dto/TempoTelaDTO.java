package br.com.projeto.checkpointjava.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TempoTelaDTO {
    private Long usuarioId;
    private String inicioSessao;
    private String fimSessao; // opcional — pode vir depois
}
